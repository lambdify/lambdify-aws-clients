package lambdify.aws.client.core.http;

import java.util.*;
import lombok.val;

public interface AwsClientJsonSerializer {

	AwsClientJsonSerializer DEFAULT = getDefaultJsonSerializer();

	String serialize(Object object);

	<T> T unserialize(String input, Class<T> clazz);

	<T> List<T> unserializeAsList(String input, Class<T> clazz);

	@SuppressWarnings( "LoopStatementThatDoesntLoop" )
	static AwsClientJsonSerializer getDefaultJsonSerializer() {
		val serializers = ServiceLoader.load( AwsClientJsonSerializer.class );
		for ( AwsClientJsonSerializer serializer : serializers ) {
			return serializer;
		}
		return null;
	}
}
