package com.study.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;


public class MyTypeHandler implements TypeHandler<String> {

    Logger logger = Logger.getLogger(MyTypeHandler.class);

    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        logger.info("设置String参数 + 【" + s + "】");
        preparedStatement.setString(i,s);
    }

    public String getResult(ResultSet resultSet, String columnLabel) throws SQLException {
        String result = resultSet.getString(columnLabel);
        logger.info("读取String参数1 + 【" + result + "】");
        return result;
    }

    public String getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String result = resultSet.getString(columnIndex);
        logger.info("读取String参数2 + 【" + result + "】");
        return result;
    }

    public String getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        String result = callableStatement.getString(columnIndex);
        logger.info("读取String参数3 + 【" + result + "】");
        return result;
    }
}
