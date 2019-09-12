package com.study.test;

import com.study.pojo.JuiceMaker2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    /**
     * 测试使用Spring IoC创建对象
     */
    @Test
    public void testJuiceMaker2(){
        //01 获取xml配置文件
        ClassPathXmlApplicationContext xml =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //02 通过配置文件对象创建我所需要的对象
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) xml.getBean("juiceMaker2");

        //03 这里跟普通方法创建的对象一样了，直接使用 对象名.方法
        String rs = juiceMaker2.makeJuice();

        //04 打印结果
        System.out.println(rs);

        //05 关闭资源
        xml.close();

    }
}
