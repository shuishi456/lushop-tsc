package com.lushop.tsc.sdk;

/**
 * Created by Administrator on 2017/7/13.
 */
public interface TransactionStateExecutor {

    <T>T call() throws Exception;

}
