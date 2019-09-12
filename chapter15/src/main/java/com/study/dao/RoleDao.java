package com.study.dao;

import com.study.pojo.Role;
import com.study.pojo.RoleParams;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    Role getRole(int id);
    List<Role> findRoles(RoleParams roleParams);
    int deleteRoles(int id);
    int insertRoles(Role role);
    int insertRole(Role role);

}
