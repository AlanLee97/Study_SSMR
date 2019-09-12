package com.study.test;

import com.study.mapper.RoleMapper;
import com.study.pojo.Role;
import com.study.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 */
public class TestMain {
    private SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    private SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.getSqlSessionFactory();
    private SqlSession sqlSession = sqlSessionFactoryUtil.getSqlSession();
    private RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

    /**
     * 测试动态SQL--if元素
     */
    @Test
    public void testFindRoles1(){
        try {
            List<Role> roles1 = mapper.findRoles1("a");
            if (null != roles1){
                System.out.println("查询成功：");
                System.out.println(roles1);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 测试动态SQL--choose,when,otherwise元素
     */
    @Test
    public void testFindRoles2(){
        try {
            Role role = new Role();
            role.setRoleNo("001");
            role.setRoleName("Alan");
            role.setNote("i am Alan");

            List<Role> roles = mapper.findRoles2(role);
            if (null != roles){
                System.out.println("查询成功：");
                System.out.println(roles);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 测试动态SQL--where元素
     */
    @Test
    public void testFindRoles3(){
        try {
            Role role = new Role();
            role.setRoleNo("001");
            role.setRoleName("Alan");
            role.setNote("i am Alan");

            List<Role> roles = mapper.findRoles3(role);
            if (null != roles){
                System.out.println("查询成功：");
                System.out.println(roles);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 测试动态SQL--trim元素
     */
    @Test
    public void testFindRoles4(){
        try {
            List<Role> roles = mapper.findRoles4("Alan");
            if (null != roles){
                System.out.println("查询成功：");
                System.out.println(roles);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 测试动态SQL--set元素
     */
    @Test
    public void testUpdateRole(){
        try {
            Role role = new Role();
            role.setRoleNo("002");
            role.setRoleName("Bob");
            role.setNote("i am Bob");

            int count = mapper.updateRole(role);
            if (count > 0){
                System.out.println("成功更新" + count +"条数据");
            }else {
                System.out.println("更新失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 测试动态SQL--foreach元素
     */
    @Test
    public void testFindRoles5(){
        try {
            List<String> roleNoList = new ArrayList<String>();
            roleNoList.add("001");
            roleNoList.add("002");

            List<Role> roles = mapper.findRoles5(roleNoList);
            if (null != roles){
                System.out.println("查询成功：");
                System.out.println(roles);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }



    /**
     * 测试动态SQL--bind元素
     */
    @Test
    public void testFindRoles6(){
        try {
            List<Role> roles = mapper.findRoles6("Alan","i am Alan");
            if (null != roles){
                System.out.println("查询成功：");
                System.out.println(roles);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }
}
