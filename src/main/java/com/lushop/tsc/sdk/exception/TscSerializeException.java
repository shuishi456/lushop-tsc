package com.lushop.tsc.sdk.exception;

/**
 * Created by Administrator on 2017/7/17.
 */
public class TscSerializeException extends  TscException {

    private static final long serialVersionUID = 2367237968979136537L;

    public TscSerializeException() {
    }

    public TscSerializeException(String message) {
        super(message);
    }

    public TscSerializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TscSerializeException(Throwable cause) {
        super(cause);
    }
}
