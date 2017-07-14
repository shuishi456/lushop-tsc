package com.lushop.tsc.sdk;

/**
 * 某个事务点的实现类，无结果返回，使用可参考${@link TransactionStateExecutor}
 * Created by Administrator on 2017/7/14.
 */
public interface TransactionStateRunnable extends  Runnable,TransactionSateExecutable{
}
