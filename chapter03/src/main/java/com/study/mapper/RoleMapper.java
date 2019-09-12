package com.study.mapper;

import com.study.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    public int insertRole(Role role);
    public int deleteRole(int id);
    public int updateRole(Role role);
    public Role getRole(int id);
    public List<Role> findRoles();
    public List<Role> findRolesByNameAndNote(Map<String, Object> parameterMap);


}
