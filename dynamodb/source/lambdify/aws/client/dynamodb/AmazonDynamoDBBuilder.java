package lambdify.aws.client.dynamodb;

import lambdify.aws.client.core.*;
import lambdify.aws.client.core.http.*;
import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(fluent = true)
public class AmazonDynamoDBBuilder extends AmazonClientBuilder<AmazonDynamoDBBuilder, AmazonDynamoDB> {

	public AmazonDynamoDBBuilder(){
		setService( "dynamodb" );
	}

	@Override
	protected AmazonDynamoDB buildClient(
			AwsClientJsonSerializer jsonSerializer, AwsCredentialsProvider credentialsProvider,
			AuthorizationHeaderAWS4Signer signer, String host)
	{
		return new AmazonDynamoDB( jsonSerializer, credentialsProvider, signer, host );
	}
}