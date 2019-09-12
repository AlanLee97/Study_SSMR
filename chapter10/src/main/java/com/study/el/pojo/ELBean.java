package com.study.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("elBean")
public class ELBean {
    //通过beanName获取bean，然后注入
    @Value("role_e")
    private Role_e role_e;

    @Value("#{role_e.id}")
    private int id;

    @Value("#{role_e.roleName}")
    private String roleName;

    @Value("#{role_e.note}")
    private String note;

}
