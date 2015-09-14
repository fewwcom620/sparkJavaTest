package model.error;

/**
 * Created by steve on 2015/9/13.
 */
public class ResponseError {
    private String message;

    public ResponseError(String message, String ...args) {
        this.message = String.format(message, args);
    }

    public ResponseError(Exception e) {
        this.message = e.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
