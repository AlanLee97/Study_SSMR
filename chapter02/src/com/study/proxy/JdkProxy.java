package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    //真实对象
    private Object target = null;

    /**
     * 建立代理对象和真实对象的代理关系
     * @param target 代理对象
     * @return 真实对象
     */
    public Object bind(Object target){
        this.target = target;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }


    /**
     * 代理逻辑方法
     * @param proxy  //代理对象
     * @param method  //当前的调度方法
     * @param args  //当前方法参数
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object object = method.invoke(target, args);
        System.out.println("在调度真实对象之后的服务");

        return object;
    }
}
