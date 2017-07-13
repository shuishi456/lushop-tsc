package com.lushop.tsc.common;

/**
 * Created by Administrator on 2017/7/12.
 */
public class Constants {

    // 事务的最大执行次数
    public static final int MAX_INVOKES = 5;
    // 执行步长
    public static final int[] INVOKES_STEP_MINUTES=new int[]{2,5,10,30,60};
    // 统一前缀
    public static final String TSC_PREFIX = "tsc_";

    // context key
    public static final String CONTEXT_EXECUTOR = TSC_PREFIX + "executor";
    public static final String CONTEXT_ADVICE_TYPE = TSC_PREFIX +"adviceType";
    public static final String CONTEXT_FIRST_STEP = TSC_PREFIX + "firstStep";
}