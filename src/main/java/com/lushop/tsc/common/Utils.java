package com.lushop.tsc.common;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2017/7/16.
 */
public class Utils {

    /**
     * 获取对应的注解类
     *
     * @param annotations
     * @param clazz
     * @param <A>
     * @return
     */
    public static <A extends Annotation> A getAnnotation(Annotation[] annotations,Class<A> clazz){
        if(ArrayUtils.isEmpty(annotations)){
            return null;
        }
        for(Annotation annotation : annotations){
            if(annotation.annotationType() == clazz){
                return (A)annotation;
            }
        }
        return null;
    }

    /**
     * 是否为异常集合的子类
     * @param exceptions
     * @param s
     * @return
     */
    public static boolean containAssignableClass(Class[] exceptions,Class s){
        if(ArrayUtils.isEmpty(exceptions)){
           return false;
        }
        for(Class ex : exceptions){
           if(ex.isAssignableFrom(s)){
               return true;
           }
        }
        return false;
    }

    /**
     * 是否存在受影响的行
     * @param affectedRows
     * @return
     */
    public static boolean existAffectedRows(Integer affectedRows){
        return affectedRows != null && affectedRows > 0;
    }

}
