package com.study.mapper;

import com.study.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     * 测试动态SQL--if元素
     */
    public List<Role> findRoles1(@Param("roleName") String name);

    /**
     * 测试动态SQL--choose,when,otherwise元素
     */
    public List<Role> findRoles2(Role role);

    /**
     * 测试动态SQL--where元素
     */
    public List<Role> findRoles3(Role role);

    /**
     * 测试动态SQL--trim元素
     */
    public List<Role> findRoles4(@Param("roleName") String roleName);

    /**
     * 测试动态SQL--set元素
     */
    public int updateRole(Role role);

    /**
     * 测试动态SQL--foreach元素
     */
    public List<Role> findRoles5(@Param("roleNoList") List<String> roleNoList);


    /**
     * 测试动态SQL--bind元素
     */
    public List<Role> findRoles6(@Param("roleName") String roleName,@Param("com.study.note") String note);

}
