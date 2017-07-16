package com.lushop.tsc.sdk.impl;

import com.lushop.tsc.common.Constants;
import com.lushop.tsc.common.Utils;
import com.lushop.tsc.sdk.*;
import com.lushop.tsc.sdk.annotation.EnableTransactionStateSnapshot;
import com.lushop.tsc.sdk.exception.TscSerializeException;
import com.lushop.tsc.sdk.internal.TransactionRecallerContext;
import com.lushop.tsc.sdk.persist.TransactionStatePersister;
import com.lushop.tsc.sdk.serialize.ArgumentSerializer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/13.
 */
public class DefaultTransactionStateExecutor  implements TransactionStateExecutor{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TscFacade tscFacade;

    public DefaultTransactionStateExecutor(TscFacade tscFacade){
        this.tscFacade = tscFacade;
    }

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
        final EnableTransactionStateSnapshot enableTransactionStateSnapshot = enableTransactionStateSnapshot(functor);
        final TransactionStateSnapshot transactionStateSnapshot = createTransactionSnapshot(functor,enableTransactionStateSnapshot);
        return null;
    }

    EnableTransactionStateSnapshot enableTransactionStateSnapshot(TransactionStateFunctor functor)throws Exception{
        final Method method = functor.method();
        // 获取方法上的注解
        final Annotation[] annotations = method.getDeclaredAnnotations();
        return Utils.getAnnotation(annotations,EnableTransactionStateSnapshot.class);
    }

    TransactionStateSnapshot createTransactionSnapshot(TransactionStateFunctor functor,EnableTransactionStateSnapshot enableTransactionStateSnapshot) throws TscSerializeException{
        final TransactionStateSnapshot transactionStateSnapshot = new TransactionStateSnapshot();
        if(enableTransactionStateSnapshot != null){
            transactionStateSnapshot.setFirstStep(enableTransactionStateSnapshot.firstStep());
            transactionStateSnapshot.setLastStep(enableTransactionStateSnapshot.lastStep());
            transactionStateSnapshot.setMaxInvokes(enableTransactionStateSnapshot.maxInvoke());
            transactionStateSnapshot.setInvokeStepMinutes(enableTransactionStateSnapshot.invokesStepMinutes());
        } else {
            transactionStateSnapshot.setFirstStep(Boolean.FALSE);
            transactionStateSnapshot.setLastStep(Boolean.FALSE);
            transactionStateSnapshot.setMaxInvokes(Constants.MAX_INVOKES);
        }
        // 如果注解上没有标注执行步长时间，则添加默认步长
        if(ArrayUtils.isEmpty(transactionStateSnapshot.getInvokeStepMinutes())){
            transactionStateSnapshot.setInvokeStepMinutes(Constants.INVOKES_STEP_MINUTES);
        }
        if(AopUtils.isAopProxy(functor.getTarget())){
            transactionStateSnapshot.setTarget(AopUtils.getTargetClass(functor.getTarget()).getClass().getName());
        }else {
            transactionStateSnapshot.setTarget(functor.getTarget().getClass().getName());
        }
        transactionStateSnapshot.setMethod(functor.getMethod());
        final TransactionStateExecutor executor = TransactionRecallerContext.attribute(Constants.CONTEXT_EXECUTOR);
        transactionStateSnapshot.setExecutor(executor == null? TransactionExecutor.SERVICER:TransactionExecutor.RECALLER);
        transactionStateSnapshot.setExecutorHost("127.0.0.1");

        try {
            transactionStateSnapshot.setArgs(argumentSerializer().serialize(functor.getArgs()));
        } catch (Exception e) {
            final String errorMsg = "can not serialize args,please check the "+ transactionStateSnapshot.getTarget()
                    +"."+transactionStateSnapshot.getMethod()+"'s args:"
                    + ToStringBuilder.reflectionToString(functor.getArgs(), ToStringStyle.SIMPLE_STYLE);
            logger.error(errorMsg);
            throw new TscSerializeException(errorMsg,e);
        }

        return transactionStateSnapshot;
    }


    public ArgumentSerializer argumentSerializer(){
        return tscFacade.argumentSerializer();
    }

    public TransactionStatePersister transactionStatePersister(){
        return tscFacade.transactionStatePersister();
    }

}
