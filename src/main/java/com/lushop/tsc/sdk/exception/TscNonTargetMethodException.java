package com.lushop.tsc.sdk.exception;

/**
 * Created by Administrator on 2017/7/13.
 */
public class TscNonTargetMethodException extends  TscException {


    private static final long serialVersionUID = -6117963294734364340L;

    public TscNonTargetMethodException() {
    }

    public TscNonTargetMethodException(String message) {
        super(message);
    }

    public TscNonTargetMethodException(String message, Throwable cause) {
        super(message, cause);
    }

    public TscNonTargetMethodException(Throwable cause) {
        super(cause);
    }
}
