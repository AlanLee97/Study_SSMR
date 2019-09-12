package com.study.main;

import com.study.mapper.RoleMapper;
import com.study.pojo.PageParams;
import com.study.pojo.Role;
import com.study.pojo.RoleParams;
import com.study.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 */
public class Main {
    /**
     * 以下为类属性
     */
    private SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    private SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.getSqlSessionFactory();
    private SqlSession sqlSession = sqlSessionFactoryUtil.getSqlSession();

    private RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);


    /**
     * 以下为类方法
     */

    /**
     * 使用map传递对个参数的方法
     * 使用map传递参数导致了业务可读性的丧失，导致后续扩展和维护的困难，在实际
     * 的应用中要果断废弃这种方式。
     */
    @Test
    public void testFindRolesByMap(){
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("roleName","a");
            map.put("com.study.note","i");
            List<Role> roleList = roleMapper.findRolesByNameAndNote(map);
            if (roleList != null){
                System.out.println("查询成功：");
                System.out.println(roleList);
            }else {
                System.out.println("查询失败");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 使用map传递对个参数的方法
     * 使用注解方式
     */
    @Test
    public void testFindRolesByAnnotation(){
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roleList = roleMapper.findRolesByAnnotation("a", "am");
            if (roleList != null){
                System.out.println("查询成功！");
                System.out.println(roleList);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 通过JavaBean的方式传递多个参数
     */
    @Test
    public void testFindRolesByJavaBean(){
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RoleParams roleParams = new RoleParams();
            roleParams.setRoleName("a");
            roleParams.setNote("am");
            List<Role> rolesByJavaBean = roleMapper.findRolesByJavaBean(roleParams);
            if (null != rolesByJavaBean){
                System.out.println("查询成功：");
                System.out.println(rolesByJavaBean);
            }else {
                System.out.println("查询失败！");
            }
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 混合几种方法来传递多个参数
     */
    @Test
    public void testFindRolesByMix(){
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RoleParams roleParams = new RoleParams();
            roleParams.setRoleName("a");
            roleParams.setNote("am");

            PageParams pageParams = new PageParams();
            pageParams.setStart(0);
            pageParams.setLimit(2);
            List<Role> rolesByMix = roleMapper.findRolesByMix(roleParams, pageParams);

            if (null != rolesByMix){
                System.out.println("查询成功：");
                System.out.println(rolesByMix);
            }else {
                System.out.println("查询失败！");
            }
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 使用resultMap作为映射结果集
     */
    @Test
    public void testFindRolesUseResultMap(){
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role rolesUseResultMap = mapper.findRolesUseResultMap(1);
            if (null != rolesUseResultMap){
                System.out.println("查询成功：");
                System.out.println(rolesUseResultMap);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 分页参数 RowBounds
     */
    @Test
    public void testFindRolesByRowBounds(){
        try {
            List<Role> rolesByRowBounds = mapper.findRolesByRowBounds("a", "am", new RowBounds(0, 3));
            if (null != rolesByRowBounds){
                System.out.println("查询成功：");
                System.out.println(rolesByRowBounds);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 插入数据：返回主键
     */
    @Test
    public void testInsertRole(){
        try {
            Role role = new Role();
            role.setRoleName("Amy");
            role.setNote("i am Amy");
            int count = mapper.insertRole(role);
            if (count > 0){
                System.out.println("数据插入成功");
                System.out.println("插入的id为：" + role.getId());
            }else {
                System.out.println("数据插入失败");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 插入数据：修改主键递增规则
     */
    @Test
    public void testInsertRole2(){
        try {
            Role role = new Role();
            role.setRoleName("Jane");
            role.setNote("i am Jane");
            int count = mapper.insertRole2(role);
            if (count > 0){
                System.out.println("数据插入成功");
                System.out.println("插入的id为：" + role.getId());
            }else {
                System.out.println("数据插入失败");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 根据id查询用户
     */
    @Test
    public void testGetRoleById(){
        try {
            Role role = mapper.getRole(1);
            if (role != null){
                System.out.println("查询成功：");
                System.out.println(role);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

}
