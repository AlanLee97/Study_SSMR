package com.study.mapper;

import com.study.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper2 {

    /**
     * 使用注解方式
     *
     */
    @Select("select id,rolename as roleName,com.study.note from role where id=#{id}")
    public Role getRole(long id);

}
