package com.study.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserRoleAssembly {
    private int id;
    private List<Role> roleList;
    private Map<Role,User> roleUserMap;
    private Set<Role> roleSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Map<Role, User> getRoleUserMap() {
        return roleUserMap;
    }

    public void setRoleUserMap(Map<Role, User> roleUserMap) {
        this.roleUserMap = roleUserMap;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "UserRoleAssembly{" +
                "id=" + id +
                ", roleList=" + roleList +
                ", roleUserMap=" + roleUserMap +
                ", roleSet=" + roleSet +
                '}';
    }
}
