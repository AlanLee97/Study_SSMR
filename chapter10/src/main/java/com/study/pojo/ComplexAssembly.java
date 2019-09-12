package com.study.pojo;

import java.util.*;

/**
 * 复杂装配类
 */
public class ComplexAssembly {
    private int id;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private Properties properties;
    private String[] array;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "ComplexAssembly{" +
                "id=" + id +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", properties=" + properties +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
