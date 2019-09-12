package com.study.typeHandler;

import com.study.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getId());
    }

    public SexEnum getNullableResult(ResultSet resultSet, String name) throws SQLException {
        int sex = resultSet.getInt(name);
        return SexEnum.getSexById(sex);
    }

    public SexEnum getNullableResult(ResultSet resultSet, int id) throws SQLException {
        int sex = resultSet.getInt(id);
        return SexEnum.getSexById(sex);
    }

    public SexEnum getNullableResult(CallableStatement callableStatement, int id) throws SQLException {
        int sex = callableStatement.getInt(id);
        return SexEnum.getSexById(sex);
    }
}
