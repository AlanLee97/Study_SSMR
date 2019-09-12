package com.study.xml.aspect;

import com.study.game.pojo.Role;
import org.aspectj.lang.ProceedingJoinPoint;

public class XMLAspect {

    /**
     * 前置通知
     */
    public void before(){
        System.out.println("before...");
    }

    /**
     * 有参数的前置通知
     */
    public void before(Role role, int sort){
        System.out.println("id:" + role.getId()
                + ", name: " + role.getRoleName()
                + ", note: " + role.getNote());
        System.out.println("sort: " + sort);
    }

    /**
     * 后置通知
     */
    public void after(){
        System.out.println("after...");
    }

    /**
     * 后置正常通知
     */
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    /**
     * 后置异常通知
     */
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    /**
     * 环绕通知
     */
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("around before...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            new RuntimeException("回调原有流程，产生异常");
        }
        System.out.println("around after...");
    }
}
