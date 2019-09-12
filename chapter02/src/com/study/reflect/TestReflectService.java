package com.study.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectService {

    public static void main(String[] args) {
//        ReflectServiceImpl2 r2 = TestReflectService.getInstance2();
//        r2.sayHello();
        TestReflectService.reflect();
    }


    /**
     * 反射生成对象
     */
    public static ReflectServiceImpl1 getInstance(){
        ReflectServiceImpl1 object = null;

        try {
            object = (ReflectServiceImpl1) Class.forName("com.study.reflect.ReflectServiceImpl1").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }


    /**
     * 构建方法含有参数的类
     */
    public static ReflectServiceImpl2 getInstance2(){
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("com.study.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 获取和反射方法
     */
    public Object reflectMethod(){
        Object returnObj = null;

        ReflectServiceImpl1 target = new ReflectServiceImpl1();
        try {
            Method method = ReflectServiceImpl1.class.getMethod("sayHello", String.class);
            method.invoke(target,"张三");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnObj;
    }

    /**
     * 反射生成对象和反射调度方法
     */
    public static Object reflect(){
        ReflectServiceImpl1 object = null;

        try {
            object = (ReflectServiceImpl1) Class.forName("com.study.reflect.ReflectServiceImpl1").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object, "张三");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }




}
