package com.study.multi_aspect.bean.impl;

import com.study.multi_aspect.bean.MultiBean;
import org.springframework.stereotype.Component;

@Component
public class MultiBeanImpl implements MultiBean {
    public void testMulti() {
        System.out.println("test Multi Aspect...");
    }
}
