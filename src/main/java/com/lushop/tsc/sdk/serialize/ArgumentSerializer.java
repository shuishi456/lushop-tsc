package com.lushop.tsc.sdk.serialize;

import java.io.IOException;

/**
 *  参数序列化定义
 * Created by Administrator on 2017/7/16.
 */
public interface ArgumentSerializer {

    /**
     * 序列化参数为字符串
     *
     * @throws IOException
     */
    String  serialize(Object arg) throws IOException;

    /**
     *
     * 反序列化
     */
    <T> T deserialize(String text) throws IOException;

}
