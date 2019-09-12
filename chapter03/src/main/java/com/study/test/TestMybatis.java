package com.study.test;

import com.study.mapper.RoleMapper;
import com.study.pojo.Role;
import com.study.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    private SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    private SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.getSqlSessionFactory();
    private SqlSession sqlSession = sqlSessionFactoryUtil.getSqlSession();


    /**
     * 根据id查询数据
     * @throws Exception
     */

    @Test
    public void findRoleById() throws Exception{
        //01 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //02 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //03 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //04.01 SqlSession执行映射文件中定义的SQL,并返回映射结果
        //Role role = sqlSession.selectOne("com.study.com.study.mapper.RoleMapper.getRole", 1);

        //04.02 通过RoleMapper接口方式发送SQl -- 通常使用这种方式
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role1 = roleMapper.getRole(1);

        //05 输出结果
        System.out.println(role1);

        //06 关闭sqlSession
        sqlSession.close();
    }


    /**
     * 查询所有数据
     */
    @Test
    public void findAllRoles() throws Exception{
        //01 获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);



        //02 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //03 通过构建SqlSessionFactory构建构建SqlSession，并打开构建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //04 发送SQL语句，采用Mapper接口方式
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roles = roleMapper.findRoles();


        //05 输出结果
        if (roles != null){
            System.out.println("成功查询所有用户数据：");
            for (Object o: roles) {
                System.out.println(o);
            }
        }else {
            System.out.println("查询所有数据失败！");
        }


        //06 提交事务
        sqlSession.commit();

        //07 关闭资源
        sqlSession.close();

    }

    /**
     * 插入数据
     */
    @Test
    public void insertRole() throws Exception {
        //01 获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //02 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //03 构建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //04 获取SqlSession,采用Mapper接口方式
        //04.01 创建Role对象，向该对象中添加数据
        Role role = new Role();
        role.setRoleName("Nibuguai");
        role.setNote("i am Nibuguai");

        //04.02 发送SQL语句
//        int count = sqlSession.insert("com.study.com.study.mapper.RoleMapper.insertRole", role);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        int count = roleMapper.insertRole(role);

        //05 输出结果
        if (count > 0){
            System.out.println("成功插入" + count + "条数据");
        }else {
            System.out.println("插入数据失败");
        }

        //06 提交事务
        sqlSession.commit();

        //07 关闭资源
        sqlSession.close();

    }


    /**
     * 更新数据
     */
    @Test
    public void updateRole() throws Exception{
        //01 获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //02 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //03 通过构建SqlSessionFactory获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //04 发送SQL语句,采用Mapper接口方式
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        //04.01 创建Role对象，将数据封装到该对象中
        Role role = new Role();
        role.setId(3);
        role.setRoleName("Nibuguai");
        int rows = roleMapper.updateRole(role);


        //05 输出结果
        if (rows > 0){
            System.out.println("成功更新" + rows + "条数据");
        }else {
            System.out.println("更新数据失败");
        }


        //06 提交事务
        sqlSession.commit();


        //07 关闭资源
        sqlSession.close();

    }


    /**
     * 删除数据
     * 根据id删除数据
     */
    @Test
    public void deleteRole() throws Exception{
        //01 获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //02 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //03 通过SqlSessionFactory构建SqlSession,并打开SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //04 发送SQL语句
        //04.01 采用Mapper接口方式发送SQL语句
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        int rows = roleMapper.deleteRole(7);

        //05 输出结果
        if (rows > 0){
            System.out.println("成功删除" + rows + "条数据");
        }else {
            System.out.println("删除数据失败");
        }

        //06 提交事务
        sqlSession.commit();

        //07 关闭资源
        sqlSession.close();


    }


    @Test
    public void testFindRolesByNameAndNote(){
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Map<String, Object> parameterMap = new HashMap<String, Object>();
            parameterMap.put("roleName","N");
            parameterMap.put("com.study.note","am");

            List<Role> roles = roleMapper.findRolesByNameAndNote(parameterMap);

            if (roles != null){
                System.out.println("查询成功：");
                for (Object obj : roles) {
                    System.out.println(roles);
                }
            }else {
                System.out.println("查询失败");
            }

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }


    }
}
