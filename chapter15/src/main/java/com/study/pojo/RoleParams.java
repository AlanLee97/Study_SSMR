package com.study.pojo;

public class RoleParams {
    private String roleName;
    private String note;
    private PageParams pageParams = null;

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

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    @Override
    public String toString() {
        return "RoleParams{" +
                "roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                ", pageParams=" + pageParams +
                '}';
    }
}
