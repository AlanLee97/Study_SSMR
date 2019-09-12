package com.study.aop.service;

import com.study.game.pojo.Role;

public interface RoleService {
    //传递一个参数
    public void printRole(Role role);
    //传递多个参数
    public void printRole(Role role, int sort);
}
