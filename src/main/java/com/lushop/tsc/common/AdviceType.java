package com.lushop.tsc.common;

/**
 * Created by Administrator on 2017/7/12.
 */
public enum AdviceType {
    BEFORE,           //执行前埋点
    AFTER_SUCCESS,    // after returning 执行成功事务结束
    AFTER_THROWING,   // after returning 执行错误，会重试
    AFTER_REENTRANT, // after returning 执行结束，允许重入
    ;

    public boolean isAfter(){  //是否已经执行
        return this != BEFORE;
    }
}
