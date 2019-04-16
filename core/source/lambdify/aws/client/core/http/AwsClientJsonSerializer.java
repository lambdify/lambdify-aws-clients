package lambdify.aws.client.core.http;

import java.util.*;
import lombok.val;

public interface AwsClientJsonSerializer {

	AwsClientJsonSerializer DEFAULT = getDefaultJsonSerializer();

	default String serialize(Object object) {
		return new String( serializeAsBytes( object ) );
	}

	byte[] serializeAsBytes(Object object);

	<T> T deserialize(String input, Class<T> clazz);

	<T> List<T> deserializeAsList(String input, Class<T> clazz);

	@SuppressWarnings( "LoopStatementThatDoesntLoop" )
	static AwsClientJsonSerializer getDefaultJsonSerializer() {
		val serializers = ServiceLoader.load( AwsClientJsonSerializer.class );
		for ( val serializer : serializers ) {
			System.err.println( "AWS Client JSON Serializer found: " + serializer.getClass().getCanonicalName() );
			return serializer;
		}

		System.err.println( "No JSON Serializer found for AWS Client implementation" );
		return null;
	}
}
