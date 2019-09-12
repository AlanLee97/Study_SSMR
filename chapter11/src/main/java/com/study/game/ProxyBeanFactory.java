package com.study.game;
import com.study.game.ProxyBeanUtil;
public class ProxyBeanFactory {
    public static <T> T getBean(T tObj, Interceptor interceptor){

        return (T) ProxyBeanUtil.getBean(tObj,interceptor);
    }
}
