package com.study.dao;

import com.study.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    public Role getRole(int id);
}
