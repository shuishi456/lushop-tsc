package com.lushop.tsc.sdk.impl;

import com.lushop.tsc.sdk.*;
import com.lushop.tsc.sdk.annotation.EnableTransactionStateSnapshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/7/13.
 */
public class DefaultTransactionStateExecutor  implements TransactionStateExecutor{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public <T> T call(TransactionStateCallable<T> callable) throws Exception {
        return null;
    }

    public <T> T call(String transactionId, Object target, String method, Object... args) throws Exception {
        return null;
    }

    public <T> T call(TransactionStateFunctor functor) throws Exception {
        return null;
    }

    public void run(TransactionStateRunnable runnable) throws Exception {

    }

    public void run(TransactionStateFunctor functor) throws Exception {

    }


    <T> T execute(TransactionStateExecutable executable,TransactionStateFunctor functor,boolean ret) throws Exception{
        // 获取注解信息
        final EnableTransactionStateSnapshot transactionStateSnapshot = null;

        final TransactionStateSnapshot
    }

}
