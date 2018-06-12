package lambdify.aws.client.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import lambdify.aws.client.core.AwsCredentials.StaticAwsCredentials;
import lombok.val;
import org.junit.jupiter.api.Test;

/**
 *
 */
class AwsCredentialsTest {

	@Test void isTemporaryCredential(){
		val credential = new StaticAwsCredentials( "123", "234", "345" );
		assertTrue( credential.isTemporaryCredential() );
	}

	@Test void isTemporaryCredential1(){
		val credential = new StaticAwsCredentials( "123", "234", null );
		assertFalse( credential.isTemporaryCredential() );
	}

	@Test void isEmpty(){
		val credential = new StaticAwsCredentials( "", "", "" );
		assertTrue( credential.isEmpty() );
	}
}