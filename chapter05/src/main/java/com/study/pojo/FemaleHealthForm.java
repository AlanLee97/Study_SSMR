package com.study.pojo;

/**
 * 女性体检表
 */
public class FemaleHealthForm extends HealthForm {
    private String uterus;

    public String getUterus() {
        return uterus;
    }

    public void setUterus(String uterus) {
        this.uterus = uterus;
    }

    @Override
    public String toString() {
        return "FemaleHealthForm{" +
                "uterus='" + uterus + '\'' +
                '}';
    }
}
