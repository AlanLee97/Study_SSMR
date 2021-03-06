package com.study.aop.service.impl;

import com.study.aop.service.RoleService;
import com.study.game.pojo.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    public void printRole(Role role) {
        Long id = role.getId();
        String roleName = role.getRoleName();
        String note = role.getNote();

        System.out.println(
                "id: " + id +
                ", roleName: " + roleName +
                ", note: " + note
        );
    }

    public void printRole(Role role, int sort) {
        Long id = role.getId();
        String roleName = role.getRoleName();
        String note = role.getNote();

        System.out.println(
                "id: " + id +
                        ", roleName: " + roleName +
                        ", note: " + note
        );
        System.out.println("sort: " + sort);
    }
}
