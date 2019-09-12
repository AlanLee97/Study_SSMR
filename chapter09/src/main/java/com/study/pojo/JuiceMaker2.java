package com.study.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 果汁生成器
 */
public class JuiceMaker2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    private String beverageShop = null;
    private Source source = null;



    public String getBeverageShop() {
        return beverageShop;
    }

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "JuiceMaker2{" +
                "beverageShop='" + beverageShop + '\'' +
                ", source=" + source +
                '}';
    }

    /**
     * 制作果汁
     * @return
     */
    public String makeJuice(){
        return "这是一杯由"+ beverageShop +"店提供的"+
                source.getSize() +
                source.getFruit() +
                source.getSugar() + "的饮料";
    }


    /**
     * 测试Spring IoC生命周期的
     */


    public void init(){
        System.out.println(this.getClass().getSimpleName() + "执行自定义的初始化方法");
    }

    public void destroy(){
        System.out.println(this.getClass().getSimpleName() + "执行自定义的销毁方法");
    }


    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware接口的setBeanFactory方法");
    }

    public void setBeanName(String s) {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanNameAware接口的setBeanName方法");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用InitializingBean接口的afterPropertiesSet方法");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware接口的setApplicationContext方法");
    }
}
