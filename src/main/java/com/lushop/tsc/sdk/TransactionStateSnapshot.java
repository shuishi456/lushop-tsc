package com.lushop.tsc.sdk;

import com.lushop.tsc.common.AdviceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/7/15.
 */
public class TransactionStateSnapshot {
    private String appName;
    private String target;
    private String method;
    private String args;
    private Boolean firstStep;
    private Boolean lastStep;
    private AdviceType adviceType;
    private String errorMessage;
    private String transactionId;
    private Integer maxInvokes;
    private TransactionExecutor executor;
    private String executorHost;
    private Timestamp recallTime;
    private int[] invokeStepMinutes;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public Boolean getFirstStep() {
        return firstStep;
    }

    public void setFirstStep(Boolean firstStep) {
        this.firstStep = firstStep;
    }

    public Boolean getLastStep() {
        return lastStep;
    }

    public void setLastStep(Boolean lastStep) {
        this.lastStep = lastStep;
    }

    public AdviceType getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(AdviceType adviceType) {
        this.adviceType = adviceType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getMaxInvokes() {
        return maxInvokes;
    }

    public void setMaxInvokes(Integer maxInvokes) {
        this.maxInvokes = maxInvokes;
    }

    public TransactionExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(TransactionExecutor executor) {
        this.executor = executor;
    }

    public String getExecutorHost() {
        return executorHost;
    }

    public void setExecutorHost(String executorHost) {
        this.executorHost = executorHost;
    }

    public Timestamp getRecallTime() {
        return recallTime;
    }

    public void setRecallTime(Timestamp recallTime) {
        this.recallTime = recallTime;
    }

    public int[] getInvokeStepMinutes() {
        return invokeStepMinutes;
    }

    public void setInvokeStepMinutes(int[] invokeStepMinutes) {
        this.invokeStepMinutes = invokeStepMinutes;
    }
}
