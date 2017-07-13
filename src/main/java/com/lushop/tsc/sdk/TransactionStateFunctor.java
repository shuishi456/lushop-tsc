package com.lushop.tsc.sdk;

import com.lushop.tsc.sdk.exception.TscNonTargetMethodException;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装事务点的类/方法/参数等信息
 * Created by Administrator on 2017/7/13.
 */
public class TransactionStateFunctor {
    private final String transactionId;
    private final Object target;
    private final String method;
    private Object[] args;

    private transient static final Map<String, Method> methodTable = new HashMap<String, Method>();

    public TransactionStateFunctor(String transactionId, Object target, String method, Object... args) {
        Assert.hasText(transactionId);
        Assert.notNull(target);
        Assert.hasText(method);
        this.transactionId = transactionId;
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object getTarget() {
        return target;
    }

    public String getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Method method() throws TscNonTargetMethodException {
        final Class<?> targetClass = this.target.getClass();
        final String key = targetClass.getName() + "." + this.method;
        Method method = methodTable.get(key);
        if (method != null) {
            return method;
        }
        method = buildMethod(targetClass, this.method);
        methodTable.put(key, method);
        return method;
    }


    static Method buildMethod(Class<?> targetClass, String methodName) throws TscNonTargetMethodException {
        Method method = null;
        Method[] methods = null;
        Class<?> itr = targetClass;
        while (!itr.equals(Object.class)) {
            methods = (Method[]) ArrayUtils.addAll(itr.getDeclaredMethods(), methods);
        }

        for (Method methodItr : methods) {
            if (methodItr.getName().equals(methodName)) {
                methodItr.setAccessible(true);
                method = methodItr;
            }
        }
        if (null == method) {
            throw new TscNonTargetMethodException("method[" + targetClass + "." + methodName + "] not exists!");
        }
        return method;
    }

    public void run() throws Exception {
        method().invoke(target, args);
    }

    public <T> T call() throws Exception {
        return (T) method().invoke(target, args);
    }

    @Override
    public String toString() {
        return "TransactionStateFunctor[" + transactionId + ">>" + target.getClass().getName() + "." + method + "(" + Arrays.toString(args) + ")]";
    }
}
