package com.study.aop.test;

import com.study.aop.config.AopConfig;
import com.study.aop.service.RoleService;
import com.study.aop.verifier.RoleVerifier;
import com.study.game.pojo.Role;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    /**
     * 测试AOP 注解方式
     */
    @org.junit.Test
    public void testAopAnnotation(){
        //获取注解方式上下文配置文件
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AopConfig.class);

        //获取XML方式上下文配置文件
//        ClassPathXmlApplicationContext xmlApplicationContext =
//                new ClassPathXmlApplicationContext("applicationContext.xml");

        RoleService roleService = applicationContext.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("Alan");
        role.setNote("i am Alan");
        System.out.println("======================正常通知====================");
        //传递一个参数
        roleService.printRole(role);
        //传递多个参数
        roleService.printRole(role, 1);

        System.out.println("======================异常通知====================");
        role = null;
        roleService.printRole(role);
        //传递多个参数
        roleService.printRole(role, 1);
    }

    /**
     * 测试AOP XML方式
     */
    @org.junit.Test
    public void testAOPXML(){
        //获取配置文件
        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = xmlApplicationContext.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("Alan");
        role.setNote("i am Alan");
        roleService.printRole(role);

        System.out.println("======================异常通知====================");
        role = null;
        roleService.printRole(role);
    }

    /**
     * 测试引入类
     */
    @org.junit.Test
    public void testVerifier(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = applicationContext.getBean(RoleService.class);

        //使用强制转换之后就可以把 roleService 转化为 RoleVerifier 接口对象,然后就可以
        //使用verify 方法了
        RoleVerifier roleVerifier = (RoleVerifier) roleService;
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("Alan");
        role.setNote("i am Alan");

        if (roleVerifier.verifier(role)){
            roleService.printRole(role);
        }
    }


}
