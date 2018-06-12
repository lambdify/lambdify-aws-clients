package lambdify.aws.client.core;

import lombok.*;

/**
 *
 */
public interface AwsCredentials {

	String getAccessKey();
	String getSecretKey();
	String getSessionKey();

	default boolean isTemporaryCredential(){
		val session = getSessionKey();
		return session != null && !session.isEmpty();
	}

	default boolean isEmpty(){
		return getAccessKey() == null || getAccessKey().isEmpty()
			|| getSecretKey() == null || getSecretKey().isEmpty();
	}

	@Value
	class StaticAwsCredentials implements AwsCredentials {
		final String accessKey;
		final String secretKey;
		final String sessionKey;
	}
}
