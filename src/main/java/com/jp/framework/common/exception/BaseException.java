package com.jp.framework.common.exception;


public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int status;

    public BaseException() {
        this(-1);
    }

    public BaseException(int status) {
        this(status, (String)null);
    }

    public BaseException(int status, String message) {
        super(message);
        this.status = status;
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return this.getMessage();
    }
}

