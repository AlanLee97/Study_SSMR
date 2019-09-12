package com.study.annotation.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用注解方式@Component装配Bean
 */
@Component(value = "role_a")
//这句话等于<bean id="role" class="com.study.annotation.pojo.Role">
public class Role_a {
    @Value("1")
    private int id;
    @Value("role_name_1")
    private String roleName;
    @Value("role_note_1")
    private String note;

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
        return "Role_a{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", com.study.note='" + note + '\'' +
                '}';
    }
}
