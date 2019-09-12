package com.study.game;

/**
 * 拦截器接口
 */
public interface Interceptor {
    //运行前
    public void before(Object obj);
    //运行后
    public void after(Object obj);
    //运行成功
    public void afterRunning(Object obj);
    //运行失败
    public void afterThrowing(Object obj);
}
