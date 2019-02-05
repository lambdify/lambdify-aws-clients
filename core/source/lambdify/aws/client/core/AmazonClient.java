package lambdify.aws.client.core;

import java.net.*;
import lambdify.aws.client.core.http.*;
import lambdify.aws.client.core.http.HttpUtils.*;
import lombok.*;

/**
 *
 */
@Getter @RequiredArgsConstructor
public abstract class AmazonClient {

	@NonNull AwsClientJsonSerializer jsonSerializer;
	@NonNull AwsCredentialsProvider provider;
	@NonNull AuthorizationHeaderAWS4Signer signer;
	@NonNull String host;

	protected <T> T sendJsonRequestAndParseResponse(Class<T> expectedResponseType, HttpRequest httpRequest) {
		val response = sendRequest( httpRequest );
		if ( response.status() == 200 ) {
			val responseAsString = response.responseAsString();
			return jsonSerializer.deserialize( responseAsString, expectedResponseType );
		}

		throw new AmazonClientException( response );
	}

	protected HttpResponse sendRequest(HttpRequest httpRequest) {
		signer.sign( httpRequest, provider.getCredentials() );
		return HttpUtils.invokeHttpRequest(httpRequest);
	}

	protected URL buildEndpoint( String uri ) {
		try {
			return new URL("https://" + host + uri );
		} catch ( MalformedURLException e ) {
			throw new HttpException( e );
		}
	}

	protected URL buildEndpoint(){
		return buildEndpoint( "/" );
	}

	public class AmazonClientException extends RuntimeException {

		@Getter
		final HttpResponse response;

		public AmazonClientException( HttpResponse response ) {
			super( "Request failure", null, true, false );
			this.response = response;
		}
	}
}
