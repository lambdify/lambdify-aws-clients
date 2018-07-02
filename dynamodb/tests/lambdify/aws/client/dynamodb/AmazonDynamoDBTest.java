package lambdify.aws.client.dynamodb;

import static lambdify.aws.client.core.http.MapBuilder.mapOf;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import lambdify.aws.client.core.AwsCredentialsProvider;
import lambdify.aws.client.dynamodb.model.*;
import lambdify.aws.events.dynamodb.AttributeValue;
import lombok.val;
import org.junit.jupiter.api.*;

/**
 *
 */
class AmazonDynamoDBTest {

	final AwsCredentialsProvider defaultCredentials =
			AwsCredentialsProvider.defaultCredentialsChain();

	final AmazonDynamoDB dynamoDB = AmazonDynamoDB.builder()
			.setCredentialsProvider( defaultCredentials )
			.setRegion( "sa-east-1" )
			.build();
	
	static final String TABLE_NAME = "Lambdify";
	
	static final Map<String, AttributeValue> ENTRY = mapOf( AttributeValue.class )
			.put( "document", AttributeValue.create().withS( "321654987" ) )
			.put( "registerDate", AttributeValue.create().withN( String.valueOf(new Date().getTime()) ) )
			.build();

	@Test
	void canDeleteItem(){
		val resultBefore = dynamoDB.scan( new ScanRequest().withTableName( TABLE_NAME ) );
		dynamoDB.putItem( new PutItemRequest().withTableName( TABLE_NAME ).withItem( ENTRY ) );
		val item = dynamoDB.getItem( new GetItemRequest().withTableName( TABLE_NAME ).withKey( ENTRY ) );
		dynamoDB.deleteItem( new DeleteItemRequest().withTableName( TABLE_NAME ).withKey( item.getItem() ) );
		val resultAfter = dynamoDB.scan( new ScanRequest().withTableName( TABLE_NAME ) );
		assertEquals( resultBefore.getCount(), resultAfter.getCount() );
	}

	@Test @Disabled
	void canPutItem(){
		val resp = dynamoDB.putItem( new PutItemRequest().withTableName( TABLE_NAME ).withItem( ENTRY ) );
		assertNotNull( resp );
	}

	@Test @Disabled
	void canGetItem(){
		val resp = dynamoDB.getItem(
			new GetItemRequest()
				.withTableName( TABLE_NAME )
				.withKey( ENTRY )
		);
		assertNotNull( resp );
	}
}