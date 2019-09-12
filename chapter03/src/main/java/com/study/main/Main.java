package com.study.main;

import com.study.mapper.RoleMapper;
import com.study.pojo.Role;
import com.study.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

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


    /**
     * 以下为类方法
     */

    /**
     * 增：插入一条数据
     */
    @Test
    public void insertRole(){

        try {
            //03 采用Mapper接口方式发送SQL语句
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("Frank");
            role.setNote("i am Frank");
            int rows = roleMapper.insertRole(role);

            //04 输出结果
            if (rows > 0){
                System.out.println("成功插入" + rows + "条数据");
            }else {
                System.out.println("插入数据失败");
            }

            //05 提交事务
            sqlSession.commit();
        } finally {
            //06 关闭资源
            sqlSession.close();
        }




    }

    /**
     * 删：根据id删除一条数据
     */
    @Test
    public void deleteRoleById(){

        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int rows = roleMapper.deleteRole(7);

            if (rows > 0){
                System.out.println("成功删除" + rows + "条数据");
            }else {
                System.out.println("删除数据失败");
            }
        } finally {
            sqlSession.close();
        }


    }

    /**
     * 查：根据id查询一条数据
     */
    @Test
    public void findRoleById(){
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1);

            if (role != null){
                System.out.println("查询数据成功！");
                System.out.println(role);
            }else {
                System.out.println("查询数据失败！");
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }



    }

    /**
     * 查：查询所有用户数据
     */
    @Test
    public void findAllRoles(){
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roles = roleMapper.findRoles();
            if (roles != null){
                System.out.println("查询数据成功：");
                for (Object obj : roles) {
                    System.out.println(obj);
                }
            }else {
                System.out.println("未查询到数据！");
            }

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }


    }

    /**
     * 改：根据id更新用户数据
     */
    @Test
    public void updateRoleById(){

    }
}
