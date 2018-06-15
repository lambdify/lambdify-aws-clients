package lambdify.aws.client.dynamodb.model;

import static org.junit.jupiter.api.Assertions.*;
import lambdify.aws.events.dynamodb.AttributeValue;
import lombok.val;
import org.junit.jupiter.api.*;

/**
 *
 */
class KeyAttributeValueBuilderTest {

	@Test @DisplayName( "Can create an Item with a key which its value is a integer" )
	void key() {
		val item = KeyAttributeValueBuilder.create()
			.key( "key", 1 )
			.build();

		assertNotNull( item );
		assertFalse( item.isEmpty() );
		assertEquals( 1, item.size() );
		assertEquals( "1", item.get( "key" ).getN() );
	}

	@Test @DisplayName( "Can create an Item with a key which its value is a long" )
	void key1() {
		val item = KeyAttributeValueBuilder.create()
				.key( "key", 1L )
				.build();

		assertNotNull( item );
		assertFalse( item.isEmpty() );
		assertEquals( 1, item.size() );
		assertEquals( "1", item.get( "key" ).getN() );
	}

	@Test @DisplayName( "Can create an Item with a key which its value is a double" )
	void key2() {
		val item = KeyAttributeValueBuilder.create()
				.key( "key", 1.0D )
				.build();

		assertNotNull( item );
		assertFalse( item.isEmpty() );
		assertEquals( 1, item.size() );
		assertEquals( "1.0", item.get( "key" ).getN() );
	}

	@Test @DisplayName( "Can create an Item with a key which its value is a boolean" )
	void key3() {
		val item = KeyAttributeValueBuilder.create()
				.key( "key", false )
				.build();

		assertNotNull( item );
		assertFalse( item.isEmpty() );
		assertEquals( 1, item.size() );
		assertFalse( item.get( "key" ).getBOOL() );
	}

	@Test @DisplayName( "Can create an Item with a key which its value is a String" )
	void key4() {
		val item = KeyAttributeValueBuilder.create()
				.key( "key", "value" )
				.build();

		assertNotNull( item );
		assertFalse( item.isEmpty() );
		assertEquals( 1, item.size() );
		assertEquals( "value", item.get( "key" ).getS() );
	}

	@Test @DisplayName( "Can create an Item with a key which its value is a custom AttributeValue" )
	void key5() {
		val item = KeyAttributeValueBuilder.create()
				.key( "key", AttributeValue.create().withNS( "first", "second" ) )
				.build();

		assertNotNull( item );
		assertFalse( item.isEmpty() );
		assertEquals( 1, item.size() );
		val list = item.get( "key" ).getNS();
		assertEquals( 2, list.size() );
		assertEquals( "first", list.get( 0 ) );
		assertEquals( "second", list.get( 1 ) );
	}
}