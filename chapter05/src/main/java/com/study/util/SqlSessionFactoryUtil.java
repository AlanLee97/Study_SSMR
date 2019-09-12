package com.study.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory = null;


    /**
     * 构建SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        // 获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }

    /**
     * 构建SqlSession,并开启SqlSession
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        return sqlSession;
    }


}
