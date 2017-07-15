package com.lushop.tsc.sdk.internal;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文工具，仅限内部使用
 *
 * Created by Administrator on 2017/7/16.
 */
public final class TransactionRecallerContext {
    private static final ThreadLocal<Map<String,Object>> context = new ThreadLocal<Map<String, Object>>(){
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    public static <T> T attribute(String key){
        return (T) context.get().get(key);
    }

    public static <T> T attribute(String key,Object value){
        return (T) context.get().put(key,value);
    }

    public static <T> T attributeIfAbsent(String key,Object value){
        final Map<String,Object> map = context.get();
        if(!map.containsKey(key)){
            return (T)map.put(key,value);
        } else {
            return (T)map.get(key);
        }
    }

    public static void remove(){
        context.remove();;
    }

    public static <T> T remove(String key){
        return (T) context.get().remove(key);
    }

}
