package com.study.aop.aspect;

import com.study.aop.verifier.RoleVerifier;
import com.study.aop.verifier.impl.RoleVerifierImpl;
import com.study.game.pojo.Role;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面Aspect的类
 */
@Aspect
public class RoleAspect {
    /**
     * 引入检测类
     */
    @DeclareParents(value = "com.study.aop.service.impl.RoleServiceImpl+",
            defaultImpl = RoleVerifierImpl.class)
    public RoleVerifier roleVerifier;


    /**
     * 为减少@Before等注解的正则表达式而写的一个方法
     */
    @Pointcut("execution(* com.study.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void print(){

    }

    /**
     * 前置通知
     */
    @Before("print()")
    //@Before("execution(* com.study.aop.service.impl.RoleServiceImpl.printRole(..))")
    //@Before("execution(* com.study.*.*.*.*.printRole(..)) && within(com.study.aop.service.impl.*))")
    public void before(){
        System.out.println("before...");
    }

    /**
     * 后置通知
     */
    @After("print()")
    //@After("execution(* com.study.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void after(){
        System.out.println("after...");

    }

    /**
     * 后置成功通知
     */
    @AfterReturning("print()")
    //@AfterReturning("execution(* com.study.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void afterReturning(){
        System.out.println("afterReturning...");

    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("print()")
    //@AfterThrowing("execution(* com.study.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing...");

    }

    /**
     * 环绕通知
     * @param joinPoint 反射切点的方法
     */
    @Around("print()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("around before...");
        try{
            joinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("around after...");
    }

    /**
     * 传递多个参数
     * @param role Role对象
     * @param sort 整型排序
     */
    public void before(Role role, int sort){
        System.out.println("before...");
    }



}
