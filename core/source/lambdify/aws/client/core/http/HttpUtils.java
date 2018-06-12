package lambdify.aws.client.core.http;

import java.io.*;
import java.net.*;
import java.util.*;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * Various Http helper routines
 */
public class HttpUtils {

    public interface Methods {
        String POST = "POST", GET = "GET", PUT = "PUT", DELETE = "DELETE";
    }

    /**
     * Makes a http request to the specified endpoint
     *
     * @param httpRequest
     * @return
     */
    public static HttpResponse invokeHttpRequest( HttpRequest httpRequest ) {
        val connection = createHttpConnection( httpRequest.endpoint, httpRequest.method, httpRequest.headers );
        try {
            if ( httpRequest.body != null )
                sendBody( connection, httpRequest.body );
            return new HttpResponse( connection.getResponseCode(), connection.getHeaderFields(), readResponse(connection) );
        } catch (Exception e) {
            throw new HttpException("Request failed. " + e.getMessage(), e);
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }

    private static HttpURLConnection createHttpConnection( URL endpointUrl, String httpMethod, Map<String, String> headers ) {
        try {
            HttpURLConnection connection = (HttpURLConnection) endpointUrl.openConnection();
            connection.setRequestMethod(httpMethod);

            if ( headers != null )
                for ( String headerKey : headers.keySet() )
                    connection.setRequestProperty( headerKey, headers.get( headerKey ) );

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("Cannot create connection. " + e.getMessage(), e);
        }
    }

    private static void sendBody( HttpURLConnection connection, byte[] body ) throws IOException {
        try ( val wr = connection.getOutputStream() ) {
            wr.write( body );
            wr.flush();
        }
    }

    private static byte[] readResponse(HttpURLConnection response) throws IOException {
        InputStream input;
        try {
            input = response.getInputStream();
        } catch ( IOException e ) {
            input = response.getErrorStream();
        }

        try {
            if ( input != null )
                return readBytes( input );
            return new byte[]{};
        } finally {
            if ( input != null )
                input.close();
        }
    }

    public static byte[] readBytes( InputStream input ) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toByteArray();
    }

    public static URL createUrl(String url) {
        try {
            return new URL( url );
        } catch ( MalformedURLException e ) {
            throw new HttpException( e );
        }
    }

    public static String urlEncode(String url){
        return urlEncode( url, false );
    }

    public static String urlEncode(String url, boolean keepPathSlash) {
        String encoded;
        try {
            encoded = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding is not supported.", e);
        }
        if ( keepPathSlash ) {
            encoded = encoded.replace("%2F", "/");
        }
        return encoded;
    }

    public static MapBuilder<String, String> createDefaultAwsHeaders(){
        return MapBuilder.mapOf( String.class )
            .put("content-type", "application/json");
    }

    @Value @Accessors(fluent = true)
    public static class HttpResponse {

        int status;
        Map<String, List<String>> headers;
        byte[] response;

        public String responseAsString(){
            try {
                return new String( response, "UTF-8" );
            } catch ( UnsupportedEncodingException e ) {
                throw new IllegalStateException( e );
            }
        }

        public Map<String, String> flatHeaders(){
            val flat = new HashMap<String, String>();
            headers.forEach( (k,v) -> flat.put( k, v.get( 0 ) ) );
            return flat;
        }
    }

    @Data @NoArgsConstructor
    @Accessors(fluent = true)
    public static class HttpRequest {
        @NonNull Map<String, String> headers = new HashMap<>();
        @NonNull URL endpoint;
        @NonNull String method;
        @NonNull byte[] body;

        {
            headers.put( "Accept","application/json" );
        }

        public HttpRequest putHeader( String name, String value ) {
            this.headers.put( name.toLowerCase(), value );
            return this;
        }

        public String host(){
            return this.headers.computeIfAbsent( "host", k -> computeHost() );
        }

        public Map<String, String> headers(){
            host();
            return headers;
        }

        public HttpRequest body( byte[] body ) {
            this.body = body;
            return this;
        }

        public HttpRequest body( String body ) {
            try {
                this.body = body.getBytes( "UTF-8" );
                return this;
            } catch ( UnsupportedEncodingException e ) {
                throw new IllegalStateException( e );
            }
        }

        public Map<String, String> queryParameters(){
            val queryParams = endpoint.getQuery();
            if ( queryParams == null || queryParams.isEmpty() )
                return Collections.emptyMap();

            val params = queryParams.split( "&" );
            val map = new HashMap<String, String>();
            for ( String param : params ) {
                val tokens = param.split( "=" );
                map.put( tokens[0].trim(), tokens[1].trim() );
            }
            return map;
        }

        private String computeHost(){
            String host = endpoint.getHost();
            int port = endpoint.getPort();

            if (port == -1) {
                return host;
            } else {
                return String.format("%s:%d", host, port);
            }
        }

        public static HttpRequest create( String method, String endpoint ) {
            return new HttpRequest().endpoint( createUrl( endpoint ) ).method( method );
        }
    }
}