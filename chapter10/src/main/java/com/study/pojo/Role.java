package com.study.pojo;

public class Role {
    private int id;
    private String roleNo;
    private String roleName;
    private String note;

    public Role(){

    }

    public Role(String roleName, String note) {
        this.roleName = roleName;
        this.note = note;
    }

    public long getId() {
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

    public String getRoleNo(String s) {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleNo='" + roleNo + '\'' +
                ", roleName='" + roleName + '\'' +
                ", com.study.note='" + note + '\'' +
                '}';
    }
}
