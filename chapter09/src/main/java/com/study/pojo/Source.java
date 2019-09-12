package com.study.pojo;

/**
 * 原料类
 */
public class Source {
    private String size;
    private String fruit;
    private String sugar;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Source{" +
                "size=" + size +
                ", fruit='" + fruit + '\'' +
                ", sugar='" + sugar + '\'' +
                '}';
    }
}
