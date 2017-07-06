package com.microservice.thunder.exception;

public class ThunderException extends RuntimeException {

    private static final long serialVersionUID = 5071078175681180222L;

    public ThunderException() {
    }

    public ThunderException(String message) {
        super(message);
    }

    public ThunderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThunderException(Throwable cause) {
        super(cause);
    }
}
