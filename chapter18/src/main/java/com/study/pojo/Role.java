package com.study.pojo;

import java.io.Serializable;

/**
 * 角色类
 * 对象要序列化，所以要实现序列化接口，还要重写serialVersionUID（书上是这么写的）
 */
public class Role implements Serializable {
    //重写serialVersionUID
    private static final long serialVersionUID = 6977402643848374753L;

    //角色名称
    private int id;
    //角色名字
    private String roleName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
