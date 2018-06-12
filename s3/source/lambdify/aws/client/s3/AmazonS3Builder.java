package lambdify.aws.client.s3;

import lambdify.aws.client.core.*;
import lambdify.aws.client.core.http.*;
import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(fluent = true)
public class AmazonS3Builder extends AmazonClientBuilder<AmazonS3Builder, AmazonS3> {

	public AmazonS3Builder(){
		setService( "s3" );
	}

	@Override
	protected AmazonS3 buildClient(
			AwsClientJsonSerializer jsonSerializer, AwsCredentialsProvider credentialsProvider,
			AuthorizationHeaderAWS4Signer signer, String host)
	{
		return new AmazonS3( jsonSerializer, credentialsProvider, signer, host );
	}

	@Override
	protected String getHost() {
		return getService() + ".amazonaws.com";
	}
}