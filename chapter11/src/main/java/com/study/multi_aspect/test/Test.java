package com.study.multi_aspect.test;

import com.study.multi_aspect.bean.MultiBean;
import com.study.multi_aspect.config.MultiConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    /**
     * 测试多个aspect
     */
    @org.junit.Test
    public void testMultiAspect(){
        //输出10个
        for (int i = 0; i < 10; i++) {
            System.out.println("#########################################");
            //获取注解配置
            AnnotationConfigApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(MultiConfig.class);
            MultiBean multiBean = applicationContext.getBean(MultiBean.class);
            multiBean.testMulti();
        }

        
    }
}
