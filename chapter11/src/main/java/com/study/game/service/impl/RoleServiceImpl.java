package com.study.game.service.impl;

import com.study.game.pojo.Role;
import com.study.game.service.RoleService;

public class RoleServiceImpl implements RoleService {

    public void printRole(Role role) {
        Long id = role.getId();
        String roleName = role.getRoleName();
        String note = role.getNote();
        System.out.println("id = " + id + ", roleName = " + roleName + ", note = " + note);
    }
}
