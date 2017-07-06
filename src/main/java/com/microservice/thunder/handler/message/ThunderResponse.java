package com.microservice.thunder.handler.message;

public class ThunderResponse extends ThunderHeader {

    private static final long serialVersionUID = 2144798686264612489L;

    private Exception exception;
    private Object result;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
