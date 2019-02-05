package lambdify.aws.client.core.http;

import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import lambdify.aws.client.core.AwsCredentials;
import lambdify.aws.client.core.http.HttpUtils.HttpRequest;
import lombok.*;

/**
 * AWS4 signer for authorization header.
 */
public class AuthorizationHeaderAWS4Signer {

    private static final String
        EMPTY_BODY_SHA256 = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        SCHEME = "AWS4",
        ALGORITHM = "HMAC-SHA256",
        TERMINATOR = "aws4_request",
        ISO8601BasicFormat = "yyyyMMdd'T'HHmmss'Z'";

    private final String serviceName;
    private final String regionName;
    private final SimpleDateFormat dateTimeFormat;

    public AuthorizationHeaderAWS4Signer(String serviceName, String regionName)
    {
        this.serviceName = serviceName;
        this.regionName = regionName;
        this.dateTimeFormat = new SimpleDateFormat(ISO8601BasicFormat);
        this.dateTimeFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
    }

    /**
     * Sign the request.
     *
     * @param httpRequest
     * @param credentials
     */
    public void sign(HttpRequest httpRequest, AwsCredentials credentials ) {
        val authorization = computeSignature( httpRequest, credentials );
        httpRequest.putHeader( "Authorization", authorization );
    }

    /**
     * Compute the request signature.
     *
     * @param httpRequest
     * @param credentials
     * @return
     */
    public String computeSignature( HttpRequest httpRequest, AwsCredentials credentials )
    {
        if ( credentials.isTemporaryCredential() )
            httpRequest.putHeader( "x-amz-security-token", credentials.getSessionKey() );

        val dateTimeStamp = dateTimeFormat.format(new Date());
        httpRequest.putHeader("x-amz-date", dateTimeStamp);

        val bodyHash = hashPayload( httpRequest.body );
        httpRequest.putHeader("x-amz-content-sha256", bodyHash);

        val headers = httpRequest.headers();
        val canonicalizedHeaderNames = getCanonicalizeHeaderNames(httpRequest.headers());
        val canonicalizedHeaders = getCanonicalizedHeaderString(headers);
        val canonicalizedQueryParameters = getCanonicalizedQueryString(httpRequest.queryParameters());

        // canonicalize the various components of the request
        val canonicalRequest = getCanonicalRequest( httpRequest.endpoint, httpRequest.method,
                canonicalizedQueryParameters, canonicalizedHeaderNames,
                canonicalizedHeaders, bodyHash);

        // construct the string to be signed
        val dateStamp = dateTimeStamp.substring( 0, 8 );
        //String dateStamp = dateStampFormat.format(now);
        val scope =  dateStamp + "/" + regionName + "/" + serviceName + "/" + TERMINATOR;
        val stringToSign = getStringToSign( dateTimeStamp, scope, canonicalRequest);

        // compute the signing key
        val kSecret = (SCHEME + credentials.getSecretKey()).getBytes();
        val kDate = sign(dateStamp, kSecret, "HmacSHA256");
        val kRegion = sign(regionName, kDate, "HmacSHA256");
        val kService = sign(serviceName, kRegion, "HmacSHA256");
        val kSigning = sign(TERMINATOR, kService, "HmacSHA256");
        val signature = sign(stringToSign, kSigning, "HmacSHA256");

        val credentialsAuthorizationHeader = "Credential=" + credentials.getAccessKey() + "/" + scope;
        val signedHeadersAuthorizationHeader = "SignedHeaders=" + canonicalizedHeaderNames;
        val signatureAuthorizationHeader = "Signature=" + toHex(signature);

        return SCHEME + "-" + ALGORITHM + " "
                + credentialsAuthorizationHeader + ", "
                + signedHeadersAuthorizationHeader + ", "
                + signatureAuthorizationHeader;
    }

    /**
     * Returns the canonical collection of header names that will be included in
     * the signature. For AWS4, all header names must be included in the process
     * in sorted canonicalized order.
     *
     * @param headers
     * @return
     */
    protected static String getCanonicalizeHeaderNames(Map<String, String> headers) {
        val sortedHeaders = new ArrayList<String>( headers.keySet() );
        sortedHeaders.sort( String.CASE_INSENSITIVE_ORDER );

        val buffer = new StringBuilder();
        for (val header : sortedHeaders) {
            if (buffer.length() > 0) buffer.append(";");
            buffer.append(header.toLowerCase());
        }

        return buffer.toString();
    }

    /**
     * Computes the canonical headers with values for the request. For AWS4, all
     * headers must be included in the signing process.
     *
     * @param headers
     * @return
     */
    protected static String getCanonicalizedHeaderString(Map<String, String> headers) {
        if ( headers == null || headers.isEmpty() ) {
            return "";
        }

        val sortedHeaders = new ArrayList<String>( headers.keySet() );
        sortedHeaders.sort( String.CASE_INSENSITIVE_ORDER );

        val buffer = new StringBuilder();
        for (String key : sortedHeaders) {
            buffer.append(key.toLowerCase().replaceAll("\\s+", " ") + ":" + headers.get(key).replaceAll("\\s+", " "));
            buffer.append("\n");
        }

        return buffer.toString();
    }

    /**
     * Returns the canonical request string to go into the signer process; this
     * consists of several canonical sub-parts.
     *
     * @param endpoint
     * @param httpMethod
     * @param queryParameters
     * @param canonicalizedHeaderNames
     * @param canonicalizedHeaders
     * @param bodyHash
     * @return
     */
    protected static String getCanonicalRequest(URL endpoint, 
                                         String httpMethod,
                                         String queryParameters, 
                                         String canonicalizedHeaderNames,
                                         String canonicalizedHeaders, 
                                         String bodyHash) {
        return
            httpMethod + "\n" +
            getCanonicalizedResourcePath(endpoint) + "\n" +
            queryParameters + "\n" +
            canonicalizedHeaders + "\n" +
            canonicalizedHeaderNames + "\n" +
            bodyHash;
    }

    /**
     * Returns the canonicalized resource path for the service endpoint.
     *
     * @param endpoint
     * @return
     */
    protected static String getCanonicalizedResourcePath(URL endpoint) {
        if ( endpoint == null ) return "/";

        val path = endpoint.getPath();
        if ( path == null || path.isEmpty() ) return "/";
        
        val encodedPath = HttpUtils.urlEncode(path, true);
        if (encodedPath.startsWith("/"))
            return encodedPath;
        else
            return "/" + encodedPath;
    }
    
    /**
     * Examines the specified query string parameters and returns a
     * canonicalized form.
     * The canonicalized query string is formed by first sorting all the query
     * string parameters, then URI encoding both the key and value and then
     * joining them, in order, separating key value pairs with an '&nbsp;'.
     *
     * @param parameters
     *            The query string parameters to be canonicalized.
     *
     * @return A canonicalized form for the specified query string parameters.
     */
    public static String getCanonicalizedQueryString(Map<String, String> parameters) {
        if ( parameters == null || parameters.isEmpty() ) {
            return "";
        }
        
        val sorted = new TreeMap<String, String>();
        var pairs = parameters.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            String key = pair.getKey();
            String value = pair.getValue();
            sorted.put(HttpUtils.urlEncode(key, false), HttpUtils.urlEncode(value, false));
        }

        val builder = new StringBuilder();
        pairs = sorted.entrySet().iterator();
        while (pairs.hasNext()) {
            val pair = pairs.next();
            builder.append(pair.getKey());
            builder.append("=");
            builder.append(pair.getValue());
            if (pairs.hasNext()) {
                builder.append("&");
            }
        }

        return builder.toString();
    }
    
    private String getStringToSign(String dateTime, String scope, String canonicalRequest) {
        return
            SCHEME + "-" + ALGORITHM + "\n" +
            dateTime + "\n" +
            scope + "\n" +
            toHex(hash(canonicalRequest));
    }

    public String hashPayload(byte[] payload) {
	    if ( payload == null )
            return EMPTY_BODY_SHA256;
	    val bodyHashBytes = hash( payload );
        return toHex(bodyHashBytes);
    }

    /**
     * Hashes the string contents (assumed to be UTF-8) using the SHA-256
     * algorithm.
     *
     * @param text
     * @return
     */
    private byte[] hash(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes("UTF-8"));
            return md.digest();
        } catch (Exception e) {
            throw new RuntimeException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }
    
    /**
     * Hashes the byte array using the SHA-256 algorithm.
     *
     * @param data
     * @return
     */
    public byte[] hash(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data);
            return md.digest();
        } catch (Exception e) {
            throw new RuntimeException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }
    
    private byte[] sign(String stringData, byte[] key, String algorithm) {
        try {
            byte[] data = stringData.getBytes("UTF-8");
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key, algorithm));
            return mac.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    /**
     * Converts byte data to a Hex-encoded string.
     *
     * @param data
     *            data to hex encode.
     *
     * @return hex-encoded string.
     */
    private String toHex(byte[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(data[i]);
            if (hex.length() == 1) {
                // Append leading zero.
                sb.append("0");
            } else if (hex.length() == 8) {
                // Remove ff prefix from negative numbers.
                hex = hex.substring(6);
            }
            sb.append(hex);
        }
        return sb.toString().toLowerCase(Locale.getDefault());
    }
}