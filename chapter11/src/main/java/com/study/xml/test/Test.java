package com.study.xml.test;

import com.study.aop.verifier.RoleVerifier;
import com.study.game.pojo.Role;
import com.study.xml.service.RoleService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    /**
     * 测试xml方式定义的AOP
     */
    @org.junit.Test
    public void testXMLAOP(){
        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        RoleService roleService = xmlApplicationContext.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("Alan");
        role.setNote("i am Alan");
        //roleService.printRole(role);
        //传递参数
//        roleService.printRole(role,1);
        //测试引入
        RoleVerifier roleVerifier = (RoleVerifier) roleService;
        if (roleVerifier.verifier(role)){
            roleService.printRole(role);
        }

    }
}
