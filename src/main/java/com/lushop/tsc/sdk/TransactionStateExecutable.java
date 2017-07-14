package com.lushop.tsc.sdk;

/**
 * 事务点的恢复需要知道类/方法/参数等信息，可参考{@link TransactionStateExecutor}
 * Created by Administrator on 2017/7/14.
 */
public interface TransactionStateExecutable {
    /**
     * 回溯事务状态需要知道的目标对象，目标方法及执行参数
     * @return
     */
    TransactionStateFunctor functor();
}
