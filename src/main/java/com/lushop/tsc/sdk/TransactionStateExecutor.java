package com.lushop.tsc.sdk;

/**
 * 业务逻辑的执行容器，拦截方法前，方法后，记录事务的状态
 * Created by Administrator on 2017/7/13.
 */
public interface TransactionStateExecutor {

    /**
     * 业务逻辑实现在 {@link TransactionStateCallable#call()}
     * @param callable
     * @param <T>
     * @return
     * @throws Exception
     */
    <T>T call(TransactionStateCallable<T> callable) throws Exception;

    /**
     * <pre>
     *     通过反射调用业务逻辑
     * </pre>
     * @param transactionId
     * @param target
     * @param method
     * @param args
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T call(String transactionId,Object target,String method,Object... args) throws Exception;

    /**
     * 通过反射调用业务逻辑
     */
    <T> T call(TransactionStateFunctor functor) throws Exception;

    /**
     * <pre>
     *     通过反射调用业务逻辑
     * </pre>
     */
    void run(TransactionStateRunnable runnable) throws Exception;

    /**
     * 通过反射调用业务逻辑
     */
    void run(TransactionStateFunctor functor) throws Exception;





}
