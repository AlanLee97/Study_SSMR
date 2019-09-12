package com.study.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassPathApplicationContext工具类
 * 1：获取ClassPathApplicationContext
 * 2：关闭ClassPathApplicationContext
 */
public class ClassPathApplicationContextUtil {
    private String xml = "applicationContext.xml";
    private ClassPathXmlApplicationContext classPathXmlApplicationContext =
            new ClassPathXmlApplicationContext(xml);

    /**
     * 获取ClassPathApplicationContext
     * @param beanName 要实例化的类的名字
     * @return
     */
    public Object getClassPathApplicationContext(String beanName){
        return classPathXmlApplicationContext.getBean(beanName);
    }

    /**
     * 关闭资源
     */
    public void closeClassPathApplicationContext(){
        classPathXmlApplicationContext.close();
    }
}
