package lambdify.aws.client.core;

import java.util.*;
import lambdify.aws.client.core.AwsCredentials.StaticAwsCredentials;
import lombok.*;

public interface AwsCredentialsProvider {

	String
		ACCESS_KEY_ENV_VAR = "AWS_ACCESS_KEY_ID",
		ALTERNATE_ACCESS_KEY_ENV_VAR = "AWS_ACCESS_KEY",
		SECRET_KEY_ENV_VAR = "AWS_SECRET_ACCESS_KEY",
		ALTERNATE_SECRET_KEY_ENV_VAR = "AWS_SECRET_ACCESS_KEY",
		SESSION_KEY_ENV_VAR = "AWS_SESSION_TOKEN",

		ACCESS_KEY_SYSTEM_PROPERTY = "aws.accessKeyId",
		SECRET_KEY_SYSTEM_PROPERTY = "aws.secretKey",
		SESSION_TOKEN_SYSTEM_PROPERTY = "aws.sessionToken"
	;

    AwsCredentials getCredentials();

    static AwsCredentialsProvider environmentCredentials(){
	    return new EnvironmentCredentialsProvider();
    }

	static AwsCredentialsProvider propertiesCredentials(){
		return staticCredentials(
			System.getProperty(ACCESS_KEY_SYSTEM_PROPERTY),
			System.getProperty(SECRET_KEY_SYSTEM_PROPERTY),
			System.getProperty(SESSION_TOKEN_SYSTEM_PROPERTY)
		);
	}

	static AwsCredentialsProvider staticCredentials( String accessKey, String secretKey ) {
		return staticCredentials( accessKey, secretKey, null );
	}

	static AwsCredentialsProvider staticCredentials( String accessKey, String secretKey, String sessionKey ) {
		return new StaticCredentialsProvider(
				new StaticAwsCredentials( accessKey, secretKey, sessionKey )
		);
	}

	static AwsCredentialsProviderChain defaultCredentialsChain(){
    	return new AwsCredentialsProviderChain();
	}

	@Value class StaticCredentialsProvider implements AwsCredentialsProvider {
		AwsCredentials credentials;
	}

	class EnvironmentCredentialsProvider implements AwsCredentialsProvider {

		@Override
		public AwsCredentials getCredentials() {
			var accessKey = System.getenv(ACCESS_KEY_ENV_VAR);
			if (accessKey == null)
				accessKey = System.getenv( ALTERNATE_ACCESS_KEY_ENV_VAR );

			var secretKey = System.getenv(SECRET_KEY_ENV_VAR);
			if (secretKey == null)
				secretKey = System.getenv( ALTERNATE_SECRET_KEY_ENV_VAR );

			val sessionToken = System.getenv(SESSION_KEY_ENV_VAR);

			return new StaticAwsCredentials( trim(accessKey), trim(secretKey), trim( sessionToken ));
		}

		static String trim( String s ) {
			if ( s == null ) return null;
			return s.trim();
		}
	}

	/**
	 *
	 */
	class AwsCredentialsProviderChain implements AwsCredentialsProvider {

		final List<AwsCredentialsProvider> providersLifo = new ArrayList<AwsCredentialsProvider>(){{
			add( environmentCredentials() );
			add( propertiesCredentials() );
		}};

		public void registerProvider( AwsCredentialsProvider provider ) {
			providersLifo.add( 0, provider );
		}

		@Override
		public AwsCredentials getCredentials() {
			for ( val provider : providersLifo ) {
				val credential = provider.getCredentials();
				if ( credential != null && !credential.isEmpty() )
					return credential;
			}
			throw new LambdaException( "No credentials defined" );
		}
	}

}