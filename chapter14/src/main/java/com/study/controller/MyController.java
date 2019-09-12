package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//用注解表示，这是一个控制器
@Controller("myController")
//表明在请求为/my的URI下才有该控制器
@RequestMapping("/my")
public class MyController {
    //表明在请求为/index的URI下才请求该方法
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        //视图逻辑名称为index
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public ModelAndView index2(){
        //带参数
//    public ModelAndView index2(@RequestParam("id") Long id){
//        System.out.println("id = " + id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
