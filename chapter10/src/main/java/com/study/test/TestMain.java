package com.study.test;

import com.study.annotation.pojo.PojoConfig;
import com.study.annotation.pojo.Role_a;
import com.study.annotation.service.RoleService2;
import com.study.pojo.ComplexAssembly;
import com.study.pojo.Role;

import com.study.pojo.UserRoleAssembly;
import com.study.util.ClassPathApplicationContextUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    private ClassPathApplicationContextUtil contextUtil = new ClassPathApplicationContextUtil();
    /**
     * 测试构造器注入
     */
    @Test
    public void testConstructDI(){
        Role role = (Role) contextUtil.getClassPathApplicationContext("role_construct");
        System.out.println(role);
        contextUtil.closeClassPathApplicationContext();
    }

    /**
     * 测试setter方式注入（常用）
     */
    @Test
    public void testSetterDI(){
        Role role = (Role) contextUtil.getClassPathApplicationContext("role_setter");
        System.out.println(role);
        contextUtil.closeClassPathApplicationContext();
    }

    /**
     * 测试复杂装配
     */
    @Test
    public void testComplexAssembly(){
        ComplexAssembly complexAssembly = (ComplexAssembly) contextUtil.getClassPathApplicationContext("complexAssembly");
        System.out.println(complexAssembly);
        contextUtil.closeClassPathApplicationContext();
    }

    @Test
    public void testUserRoleAssembly(){
        UserRoleAssembly userRoleAssembly = (UserRoleAssembly) contextUtil.getClassPathApplicationContext("userRoleAssembly");
        System.out.println(userRoleAssembly);
        contextUtil.closeClassPathApplicationContext();
    }

    /**
     * 测试使用注解方式装配Bean
     */
    @Test
    public void testAnnotationAssemblyBean(){
        //01 使用AnnotationConfigApplicationContext找到扫描类
        AnnotationConfigApplicationContext configApplicationContext = new
                AnnotationConfigApplicationContext(PojoConfig.class);
        //02 通过找到的扫描类获取bean
        Role_a roleA = configApplicationContext.getBean(Role_a.class);
        //03 输出结果
        System.out.println(roleA);
        //04 关闭资源
        configApplicationContext.close();
    }

    /**
     * 测试自动装配@Autowired
     */
    @Test
    public void testAutowired(){
        //01 获取上下文配置文件
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationContext.class);
        //02 获取bean
        RoleService2 roleService2 = (RoleService2) applicationContext.getBean("roleService2");
        //03
        roleService2.printRoleInfo();
        //04 关闭资源
        applicationContext.close();

    }
}
