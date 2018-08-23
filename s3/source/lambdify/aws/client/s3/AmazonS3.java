package lambdify.aws.client.s3;

import java.io.*;
import java.net.*;
import lambdify.aws.client.core.*;
import lambdify.aws.client.core.http.*;
import lambdify.aws.client.core.http.HttpUtils.*;
import lambdify.aws.client.s3.model.*;
import lombok.*;
import lombok.experimental.*;

/**
 *
 */
@FieldDefaults( level = AccessLevel.PROTECTED, makeFinal = true )
@Getter @Accessors(fluent = true)
public class AmazonS3 extends AmazonClient {

	public AmazonS3(
			AwsClientJsonSerializer jsonSerializer, AwsCredentialsProvider provider,
			AuthorizationHeaderAWS4Signer signer, String host) {
		super( jsonSerializer, provider, signer, host );
	}

	public S3Object getObject( String bucket, String key ) {

		val request = new HttpUtils.HttpRequest().endpoint( buildEndpoint( bucket, key ) ).method( Methods.GET );
		val response = sendRequest( request );
		val headers = response.flatHeaders();
		return new S3Object().setKey( key ).setBucketName( bucket )
				.setMetadata( new ObjectMetadata().setMetadata( headers ) )
				.setObjectContent( new ByteArrayInputStream( response.response() ) );
	}

	public void putObject(String bucket, String key, byte[] bytes ) {
		val request = new HttpUtils.HttpRequest().endpoint( buildEndpoint( bucket, key ) )
				.method( Methods.PUT )
				.putHeader( "Content-Length", String.valueOf( bytes.length ) )
				.body( bytes );
		sendRequest( request );
	}

	public void putObject(String bucket, String key, Object object ) {
		val bytes = getJsonSerializer().serializeAsBytes( object );
		putObject( bucket, key, bytes );
	}

	protected HttpResponse sendRequest(HttpRequest request) {
		val response = super.sendRequest( request );
		if ( response.status() > 299 )
			throw new AmazonS3ExecutionFailure( response.responseAsString() );
		return response;
	}

	private URL buildEndpoint(String bucket, String key) {
		if ( key.charAt( 0 ) != '/' )
			key = "/" + key;

		try {
			return new URL("https://" +  getHost() + "/" + bucket + key );
		} catch ( MalformedURLException e ) {
			throw new HttpException( e );
		}
	}

	public static AmazonS3Builder builder(){
		return new AmazonS3Builder();
	}

	public static class AmazonS3ExecutionFailure extends AmazonClientExecutionFailure {

		public AmazonS3ExecutionFailure(String msg) {
			super(msg);
		}
	}
}