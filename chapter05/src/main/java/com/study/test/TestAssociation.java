package com.study.test;

import com.study.mapper.EmployeeMapper;
import com.study.pojo.Employee;
import com.study.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestAssociation {
    private SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    private SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.getSqlSessionFactory();
    private SqlSession sqlSession = sqlSessionFactoryUtil.getSqlSession();

    /**
     * 测试级联
     */
    @Test
    public void testGetEmployee(){
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployee(1);
            if (employee != null){
                System.out.println("查询成功：");
                System.out.println(employee);
            }else {
                System.out.println("查询失败！");
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


}
