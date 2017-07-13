package com.lushop.tsc.sdk.exception;

/**
 * Created by Administrator on 2017/7/13.
 */
public class TscException extends  Exception {


    private static final long serialVersionUID = -6962414425433193261L;

    public TscException() {
    }

    public TscException(String message) {
        super(message);
    }

    public TscException(String message, Throwable cause) {
        super(message, cause);
    }

    public TscException(Throwable cause) {
        super(cause);
    }
}
