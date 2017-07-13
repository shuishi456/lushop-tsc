package com.lushop.tsc.sdk.annotation;

import com.lushop.tsc.common.Constants;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/7/12.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface EnableTransactionStateSnapshot {

    /**
     * 定义那些异常需要终止事务，标记事务状态
     * @return
     */
    Class<? extends Throwable>[] failFor() default {};

    /**
     * 是否是第一步
     * @return
     */
    boolean firstStep() default false;

    /**
     * 是否最后一步
     * @return
     */
    boolean lastStep() default false;

    /**
     * 方法最多被执行几次，防止重试过多引起各种问题
     * @return
     */
    int maxInvoke() default Constants.MAX_INVOKES;

    /**
     * 方法执行的步长时间，保证在不均匀的时间段内被执行，如果最大执行次数大于设置的步长列表，则后续执行步长取列表最后项
     * 与{@link Constants#INVOKES_STEP_MINUTES}保持同步
     * @return
     */
    int[] invokesStepMinutes() default {2,5,10,30,60};








}
