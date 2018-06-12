package lambdify.aws.client.core;

import static lambdify.aws.client.core.AwsCredentialsProvider.defaultCredentialsChain;
import lambdify.aws.client.core.http.*;
import lombok.*;

@NoArgsConstructor
public abstract class AmazonClientBuilder<BUILDER extends AmazonClientBuilder, CLIENT> {

	@NonNull private AwsClientJsonSerializer jsonSerializer = getJsonSerializer();
	@NonNull private String region = "us-east-1";

	@NonNull private AwsCredentialsProvider credentialsProvider = defaultCredentialsChain();
	@NonNull private String service;

	private AwsClientJsonSerializer getJsonSerializer() {
		if ( jsonSerializer == null )
			this.jsonSerializer = AwsClientJsonSerializer.getDefaultJsonSerializer();
		return jsonSerializer;
	}

	public CLIENT build() {
		val signer = new AuthorizationHeaderAWS4Signer( getService(), getRegion() );
		return buildClient( getJsonSerializer(), getCredentialsProvider(), signer, getHost() );
	}

	protected String getHost() {
		return getService() + "." + getRegion() + ".amazonaws.com";
	}

	protected abstract CLIENT buildClient(
			AwsClientJsonSerializer jsonSerializer, AwsCredentialsProvider credentialsProvider,
			AuthorizationHeaderAWS4Signer signer, String host);

	private BUILDER getBuilder(){
		return (BUILDER)this;
	}

	public BUILDER setJsonSerializer(AwsClientJsonSerializer jsonSerializer) {
		this.jsonSerializer = jsonSerializer;
		return getBuilder();
	}

	public String getRegion() {
		return region;
	}

	public BUILDER setRegion(String region) {
		this.region = region;
		return getBuilder();
	}

	public AwsCredentialsProvider getCredentialsProvider() {
		return credentialsProvider;
	}

	public BUILDER setCredentialsProvider(AwsCredentialsProvider credentialsProvider) {
		this.credentialsProvider = credentialsProvider;
		return getBuilder();
	}

	public String getService() {
		return service;
	}

	public BUILDER setService(String service) {
		this.service = service;
		return getBuilder();
	}
}