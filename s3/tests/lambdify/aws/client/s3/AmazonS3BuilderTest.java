package lambdify.aws.client.s3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import lombok.val;
import org.junit.jupiter.api.*;

/**
 *
 */
class AmazonS3BuilderTest {

	@DisplayName( "Will use s3.amazonaws.com as host when no region is defined" )
	@Test void getHost() {
		val builder = new AmazonS3Builder();
		assertEquals( "s3.amazonaws.com", builder.getHost() );
	}

	@DisplayName( "Will use s3.amazonaws.com as host when North Virginia is defined as region" )
	@Test void getHost1() {
		val builder = new AmazonS3Builder().setRegion( "us-east-1" );
		assertEquals( "s3.amazonaws.com", builder.getHost() );
	}

	@DisplayName( "Will use region based host when a different region is defined" )
	@Test void getHost2() {
		val builder = new AmazonS3Builder().setRegion( "sa-east-1" );
		assertEquals( "s3-sa-east-1.amazonaws.com", builder.getHost() );
	}
}