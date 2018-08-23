package lambdify.aws.client.core.http;

import lombok.Getter;

@Getter
public class HttpRequestFailure extends HttpException {

    final int status;
    final String responseBody;

    public HttpRequestFailure(int status, String responseBody ){
        super("Status: " + status + "; Response Body: " + responseBody);
        this.status = status;
        this.responseBody = responseBody;
    }
}
