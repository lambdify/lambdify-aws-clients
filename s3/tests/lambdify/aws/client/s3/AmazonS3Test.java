package lambdify.aws.client.s3;

import static lambdify.aws.client.core.AwsCredentialsProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import lombok.*;
import org.junit.jupiter.api.Test;

/**
 *
 */
class AmazonS3Test {

	static final String SAMPLE_JSON = "{ \"hello\": \"mate\" }";

	final AmazonS3 s3 = AmazonS3.builder()
			.setCredentialsProvider( defaultCredentialsChain() )
			.setRegion( "sa-east-1" )
			.build();

	@SneakyThrows
	@Test void canGetObject(){
		s3.putObject( "lambdify", "sample.json", SAMPLE_JSON.getBytes( "UTF-8" ) );

		val object = s3.getObject( "lambdify", "/sample.json" );
		val contentLength = Integer.valueOf( (String)object.getMetadata().getMetadata().get( "Content-Length" ) );
		val buffer = new byte[contentLength];
		try ( val content = ((ByteArrayInputStream)object.getObjectContent()) ) {
			content.read( buffer, 0, contentLength );
		}

		assertEquals( SAMPLE_JSON, new String(buffer) );
	}

	@SneakyThrows
	@Test void canPutObject(){
		s3.putObject( "lambdify", "/sample.json", SAMPLE_JSON.getBytes( "UTF-8" ) );
	}
}