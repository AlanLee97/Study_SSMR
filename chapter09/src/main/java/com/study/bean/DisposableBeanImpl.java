package com.study.bean;

import org.springframework.beans.factory.DisposableBean;

public class DisposableBeanImpl implements DisposableBean {
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean接口的destroy()方法");
    }
}
