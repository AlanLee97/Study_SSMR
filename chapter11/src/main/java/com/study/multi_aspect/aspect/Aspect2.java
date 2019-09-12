package com.study.multi_aspect.aspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class Aspect2 {

    @Pointcut("execution(* com.study.multi_aspect.bean.impl.MultiBeanImpl.testMulti(..))")
    public void print(){

    }

    @Before("print()")
    public void before(){
        System.out.println("before2...");
    }

    @After("print()")
    public void after(){
        System.out.println("after2...");
    }

    @AfterReturning("print()")
    public void afterReturning(){
        System.out.println("afterReturning2...");
    }

    @AfterThrowing("print()")
    public void afterThrowing(){
        System.out.println("afterThrowing2...");
    }
}
