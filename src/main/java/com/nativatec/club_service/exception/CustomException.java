package com.nativatec.club_service.exception;

public class CustomException extends RuntimeException {
    private int statusCode;
    public CustomException(int statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public CustomException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public CustomException(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public CustomException(Throwable cause, int statusCode) {
        super(cause);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
