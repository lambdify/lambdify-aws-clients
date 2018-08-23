package lambdify.aws.client.core;

public class AmazonClientExecutionFailure extends RuntimeException {

	public AmazonClientExecutionFailure(String msg) {
		super( msg, null, true, false );
	}
}