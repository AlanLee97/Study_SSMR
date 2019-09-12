package com.study.multi_aspect.config;

import com.study.multi_aspect.aspect.Aspect1;
import com.study.multi_aspect.aspect.Aspect2;
import com.study.multi_aspect.aspect.Aspect3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.study.multi_aspect")
public class MultiConfig {
    @Bean
    public Aspect1 getAspect1(){
        return new Aspect1();
    }

    @Bean
    public Aspect2 getAspect2(){
        return new Aspect2();
    }

    @Bean
    public Aspect3 getAspect3(){
        return new Aspect3();
    }
}
