package com.study.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[0];
    }
}
