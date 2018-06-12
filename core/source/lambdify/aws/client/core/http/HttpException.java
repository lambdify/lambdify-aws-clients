package lambdify.aws.client.core.http;

/**
 *
 */
public class HttpException extends RuntimeException {

	final String type;

	public HttpException(String message, Throwable cause) {
		super(message, cause);
		type = "Unknown";
	}

	public HttpException(String message) {
		super(message);
		type = "Unknown";
	}

	public HttpException(String type, String message) {
		super(message);
		this.type = type;
	}

	public HttpException(Throwable cause) {
		super(cause);
		type = "Unknown";
	}
}
