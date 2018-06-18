package lambdify.aws.client.s3;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import lambdify.aws.client.core.http.AwsClientJsonSerializer;

/**
 * Sample serializer.
 */
public class JacksonSerializer implements AwsClientJsonSerializer {

	final ObjectMapper objectMapper = new ObjectMapper();

	{
		objectMapper
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
		;
	}

	@Override
	public String serialize( Object object ) {
		try {
			return objectMapper.writeValueAsString( object );
		} catch ( JsonProcessingException e ) {
			throw new IllegalStateException( e );
		}
	}

	@Override
	public byte[] serializeAsBytes(Object object) {
		try {
			return objectMapper.writeValueAsBytes( object );
		} catch ( JsonProcessingException e ) {
			throw new IllegalStateException( e );
		}
	}

	@Override
	public <T> T unserialize(String input, Class<T> clazz) {
		try {
			return objectMapper.readValue( input, clazz );
		} catch ( IOException e ) {
			throw new IllegalStateException( e );
		}
	}

	@Override
	public <T> List<T> unserializeAsList(String input, Class<T> clazz) {
		throw new UnsupportedOperationException( "unserializeAsList not implemented yet!" );
	}
}
