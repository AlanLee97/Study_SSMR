package com.study.game;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static sun.net.www.protocol.http.AuthCacheValue.Type.Proxy;

public class ProxyBeanUtil implements InvocationHandler {
    //被代理对象
    private Object obj;
    //拦截器
    private Interceptor interceptor = null;

    /**
     * 获取动态代理对象
     * @param obj 被代理的对象
     * @param interceptor 拦截器
     * @return 动态代理对象
     */
    public static Object getBean(Object obj, Interceptor interceptor){
        ProxyBeanUtil _this = new ProxyBeanUtil();
        _this.obj = obj;
        _this.interceptor = interceptor;
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                _this);

    }

    /**
     * 代理方法
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 参数
     * @return 返回值
     * @throws Throwable 抛出异常
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retObj = null;
        //是否产生异常
        boolean exceptionFlag = false;

        //before方法
        interceptor.before(obj);

        try {
            //反射原有的方法
            retObj = method.invoke(obj,args);
        } catch (Exception e) {
            exceptionFlag = true;
        } finally {
            //after方法
            interceptor.after(obj);
        }

        if (exceptionFlag){
            //afterThrowing方法
            interceptor.afterThrowing(obj);
        }else {
            //afterRunning方法
            interceptor.afterRunning(obj);
        }





        return null;
    }
}
