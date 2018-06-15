package lambdify.aws.client.dynamodb.model;

import java.util.*;
import lambdify.aws.events.dynamodb.AttributeValue;
import lombok.NoArgsConstructor;

/**
 *
 */
@NoArgsConstructor(staticName = "create")
public class KeyAttributeValueBuilder {

	private Map<String, AttributeValue> item = new HashMap<>();

	public KeyAttributeValueBuilder key(String name, String value ) {
		return key( name, AttributeValue.create(value) );
	}

	public KeyAttributeValueBuilder key(String name, boolean value ) {
		return key( name, AttributeValue.create(value) );
	}

	public KeyAttributeValueBuilder key(String name, long value ) {
		return key( name, AttributeValue.create(value) );
	}

	public KeyAttributeValueBuilder key(String name, double value ) {
		return key( name, AttributeValue.create(value) );
	}

	public KeyAttributeValueBuilder key(String name, int value ) {
		return key( name, AttributeValue.create(value) );
	}

	public KeyAttributeValueBuilder key(String name, AttributeValue attributeValue ) {
		item.put( name, attributeValue );
		return this;
	}

	public Map<String, AttributeValue> build(){
		return item;
	}
}
