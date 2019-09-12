package com.study.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "role_e")
public class Role_e {
    //赋值int型
    @Value("#{1}")
    private int id;
    //字符串赋值
    @Value("#{'role_e_name'}")
    private String roleName;
    //字符串赋值
    @Value("#{'role_e_note'}")
    private String note;

    public Role_e() {
    }

    public Role_e(int id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role_e{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", com.study.note='" + note + '\'' +
                '}';
    }
}
