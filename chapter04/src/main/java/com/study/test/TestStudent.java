package com.study.test;

import com.study.mapper.StudentMapper;
import com.study.pojo.Student;
import com.study.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class TestStudent {
    /**
     * 把SqlSessionFactoryUtil导进来
     * 放在三个属性中
     */
    private SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    private SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.getSqlSessionFactory();
    private SqlSession sqlSession = sqlSessionFactoryUtil.getSqlSession();


    /**
     * =======================================================================
     * 以下是测试方法
     */


    /**
     * 测试--查：通过学生id查询学生数据
     */
    @Test
    public void findStudentById(){
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.findStudentById(1);
            if (null != student){
                System.out.println("查询数据成功：");
                System.out.println(student);
            }else {
                System.out.println("查询数据失败");
            }

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    /**
     * 查询所有学生的数据
     */
    @Test
    public void findAllStudents(){
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> allStudents = studentMapper.findAllStudents();

            if (allStudents != null){
                System.out.println("查询成功：");
                for (Object obj : allStudents) {
                    System.out.println(obj);
                }
            }else {
                System.out.println("未查询到结果");
            }

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

}
