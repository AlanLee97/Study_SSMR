package com.study.test;

import com.study.pojo.Role;
import com.study.service.RoleListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        RoleListService roleListService = applicationContext.getBean(RoleListService.class);
        List<Role> roleList = new ArrayList<Role>();
        for (int i = 1; i <= 2; i++) {
            Role role = new Role();
            role.setRoleName("Lee" + i);
            role.setNote("i am Lee" + i);
            roleList.add(role);
        }
        int count = roleListService.insertRoleList(roleList);
        System.out.println("count: " + count);

    }
}
