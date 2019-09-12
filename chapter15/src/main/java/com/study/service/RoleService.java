package com.study.service;

import com.study.pojo.Role;
import com.study.pojo.RoleParams;

import java.util.List;

public interface RoleService {
    public Role getRole(int id);
    public List<Role> findRoles(RoleParams roleParams);
    public int deleteRoles(List<Integer> idList);
    public int insertRoles(List<Role> roleList);
    public int insertRole(Role role);
}
