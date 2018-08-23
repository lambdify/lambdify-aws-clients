package lambdify.aws.client.dynamodb;

import java.util.Map;
import lambdify.aws.client.core.*;
import lambdify.aws.client.core.http.*;
import lambdify.aws.client.core.http.HttpUtils.*;
import lambdify.aws.client.dynamodb.model.*;
import lombok.*;
import lombok.experimental.*;

/**
 *
 */
@FieldDefaults( level = AccessLevel.PROTECTED, makeFinal = true )
@Getter @Accessors(fluent = true)
public class AmazonDynamoDB extends AmazonClient {

	private static final String
			OPERATION_PUT_ITEM = "DynamoDB_20120810.PutItem",
			OPERATION_GET_ITEM = "DynamoDB_20120810.GetItem",
			OPERATION_DELETE_ITEM = "DynamoDB_20120810.DeleteItem",
			OPERATION_UPDATE_ITEM = "DynamoDB_20120810.UpdateItem",
			OPERATION_QUERY = "DynamoDB_20120810.Query",
			OPERATION_SCAN = "DynamoDB_20120810.Scan"
					;

	public AmazonDynamoDB(
			AwsClientJsonSerializer jsonSerializer, AwsCredentialsProvider provider,
			AuthorizationHeaderAWS4Signer signer, String host) {
		super( jsonSerializer, provider, signer, host );
	}

	public PutItemResult putItem( PutItemRequest request ) {
		return executeOperation( request, OPERATION_PUT_ITEM, PutItemResult.class );
	}

	public GetItemResult getItem( GetItemRequest request ) {
		return executeOperation( request, OPERATION_GET_ITEM, GetItemResult.class );
	}

	public DeleteItemResult deleteItem( DeleteItemRequest request ) {
		return executeOperation( request, OPERATION_DELETE_ITEM, DeleteItemResult.class );
	}

	public UpdateItemResult updateItem( UpdateItemResult request ) {
		return executeOperation( request, OPERATION_UPDATE_ITEM, UpdateItemResult.class );
	}

	public QueryResult query( QueryRequest request ) {
		return executeOperation( request, OPERATION_QUERY, QueryResult.class );
	}

	public ScanResult scan( ScanRequest request ) {
		return executeOperation( request, OPERATION_SCAN, ScanResult.class );
	}

	private <T> T executeOperation( Object cmd, String operation, Class<T> expectedResultType ){
		val objectContent = getJsonSerializer().serialize( cmd );
		val headers = HttpUtils.createDefaultAwsHeaders()
				.put("X-Amz-Target", operation )
				.put("content-length", String.valueOf( objectContent.length() ))
				.build();

		return sendJsonRequestAndParseResponse( expectedResultType, new HttpUtils.HttpRequest()
				.endpoint( buildEndpoint() ).method( Methods.POST )
				.headers( headers ).body( objectContent )
		);
	}

	@Override
	protected <T> T sendJsonRequestAndParseResponse(Class<T> expectedResponseType, HttpRequest httpRequest) {
		try {
			return super.sendJsonRequestAndParseResponse( expectedResponseType, httpRequest );
		} catch ( AmazonClientException cause ) {
			val responseAsString = cause.getResponse().responseAsString();
			val any = getJsonSerializer().unserialize( responseAsString, Map.class );
			val type = any.get( "__type" ).toString().replaceFirst( "^.*#", "" );
			val message = any.containsKey( "Message" )
					? any.get( "Message" ).toString()
					: any.get( "message" ).toString();
			throw new AmazonDynamoDBExecutionFailure( type, message );
		}
	}

	public static AmazonDynamoDBBuilder builder(){
		return new AmazonDynamoDBBuilder();
	}

	@Getter
	public static class AmazonDynamoDBExecutionFailure extends AmazonClientExecutionFailure {

		final String type;
		final String response;

		public AmazonDynamoDBExecutionFailure(String type, String response) {
			super("Type: " + type + "; Response: " + response);
			this.type = type;
			this.response = response;
		}
	}
}
