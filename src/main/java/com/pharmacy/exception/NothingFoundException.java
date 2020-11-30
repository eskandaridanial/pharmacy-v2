package com.pharmacy.exception;

public class NothingFoundException extends RuntimeException {

    public NothingFoundException() {
        super();
    }

    public NothingFoundException(String message) {
        super(message);
    }

    public NothingFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NothingFoundException(Throwable cause) {
        super(cause);
    }

    protected NothingFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
