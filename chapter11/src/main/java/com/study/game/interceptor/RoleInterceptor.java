package com.study.game.interceptor;

import com.study.game.Interceptor;

public class RoleInterceptor implements Interceptor {
    public void before(Object obj) {
        System.out.println("准备打印角色信息");
    }

    public void after(Object obj) {
        System.out.println("已经完成角色信息的打印处理");

    }

    public void afterRunning(Object obj) {
        System.out.println("刚刚完成打印功能，一切正常。");

    }

    public void afterThrowing(Object obj) {
        System.out.println("打印功能执行异常了，查看一下角色对象为空了吗？");

    }
}
