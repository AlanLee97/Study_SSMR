package com.study.reflect;

public class ReflectServiceImpl2 {
    private String name;
    public void sayHello(){
        System.out.println("Hello" + name);
    }

    public ReflectServiceImpl2(String name){
        this.name = name;
    }


}
