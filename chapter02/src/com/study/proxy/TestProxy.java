package com.study.proxy;

public class TestProxy {
    public static void main(String[] args) {
        testJdkProxy();
    }

    /**
     * 测试jdk动态代理
     */
    public static void testJdkProxy(){
        JdkProxy jdkProxy = new JdkProxy();

        //绑定关系，因为挂在接口HelloWorld下，所以声明代理对象HelloWorld proxy
        HelloWorld proxy = (HelloWorld) jdkProxy.bind(new HelloWorldImpl());

        //此时HelloWorld对象已经是代理对象，它会进入代理的逻辑方法invoke里面
        proxy.sayHelloWorld();
    }
}
