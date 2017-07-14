package com.lushop.tsc.sdk;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/7/13.
 */
public interface TransactionStateCallable<V> extends Callable<V>,TransactionStateExecutable{
}
