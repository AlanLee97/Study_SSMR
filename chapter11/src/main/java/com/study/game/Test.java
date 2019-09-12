package com.study.game;

import com.study.game.interceptor.RoleInterceptor;
import com.study.game.pojo.Role;
import com.study.game.service.RoleService;
import com.study.game.service.impl.RoleServiceImpl;

public class Test {
    public static void main(String[] args) {
        RoleService roleService = new RoleServiceImpl();
        Interceptor interceptor = new RoleInterceptor();
        //获取bean的方法
        RoleService proxy = ProxyBeanFactory.getBean(roleService, interceptor);

        System.out.println("##############测试afterRunning方法###############");
        Role role = new Role(1L,"Alan","i am Alan");
        proxy.printRole(role);

        System.out.println("##############测试afterThrowing方法###############");
        role = null;
        proxy.printRole(role);
    }
}
