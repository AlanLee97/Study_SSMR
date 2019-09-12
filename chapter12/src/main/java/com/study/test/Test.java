package com.study.test;

import com.study.mapper.RoleMapper;
import com.study.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    /**
     * 测试整合的mybatis和spring
     */
    @org.junit.Test
    public void testMybatisSpring(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleMapper roleMapper = applicationContext.getBean(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("Alan");
        role.setNote("i am Alan");

        //插入数据
        /*int count = roleMapper.insert(role);
        if (count > 0){
            System.out.println("插入数据成功！");
        }else {
            System.out.println("插入数据失败");
        }*/


        //查询数据
        Role role1 = roleMapper.getRole(14);
        if (role1 != null){
            System.out.println(role1);
        }else {
            System.out.println("select failed!");
        }

        //更新数据
        /*role.setId(15);
        int count2 = roleMapper.update(role);
        if (count2 > 0){
            System.out.println("更新数据成功！");
        }else {
            System.out.println("更新数据失败");
        }*/


        //删除数据
        /*int count3 = roleMapper.delete(15);
        if (count3 > 0){
            System.out.println("删除数据成功！");
        }else {
            System.out.println("删除数据失败！");
        }*/
    }
}
