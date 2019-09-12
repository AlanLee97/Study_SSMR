package com.study.annotation.service.impl;

import com.study.annotation.pojo.Role_a;
import com.study.annotation.service.RoleService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试自动装配@Autowired
 */
@Component("roleService02")
public class RoleServiceImpl2 implements RoleService2 {
    //自动装配：配置在属性中
    @Autowired(required = false)
    private Role_a role_a = null;

    public Role_a getRole_a() {
        return role_a;
    }

    //自动装配：配置在方法中
//    @Autowired
    public void setRole_a(Role_a role_a) {
        this.role_a = role_a;
    }

    public void printRoleInfo() {
        System.out.println("id = " + role_a.getId());
        System.out.println("roleName = " + role_a.getRoleName());
        System.out.println("com.study.note = " + role_a.getNote());

    }
}
