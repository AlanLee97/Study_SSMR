package com.study.pojo;

public class MaleEmployee extends Employee{
    private MaleHealthForm maleHealthForm = null;

    public MaleHealthForm getMaleHealthForm() {
        return maleHealthForm;
    }

    public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
        this.maleHealthForm = maleHealthForm;
    }

    public MaleEmployee() {
    }

    @Override
    public String toString() {
        return "MaleEmployee{" +
                "maleHealthForm=" + maleHealthForm +
                '}';
    }
}
