package com.lushop.tsc.sdk;

import com.lushop.tsc.sdk.persist.TransactionStatePersister;
import com.lushop.tsc.sdk.serialize.ArgumentSerializer;

/**
 * Created by Administrator on 2017/7/16.
 */
public interface TscFacade {

    ArgumentSerializer argumentSerializer();

    TransactionStatePersister transactionStatePersister();

}
