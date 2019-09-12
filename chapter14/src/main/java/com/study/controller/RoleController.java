package com.study.controller;

import com.study.pojo.Role;
import com.study.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/role")
public class RoleController {
    //注入角色服务类
    @Autowired
    private RoleService roleService = null;

    @RequestMapping(value = "/getRole", method = RequestMethod.GET)
    public ModelAndView getRole(@RequestParam("id") int id){
        Role role = roleService.getRole(id);
        System.out.println(role);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleDetails");
        modelAndView.addObject("role", role);
        return modelAndView;
    }

    //将数据转为json格式
    @RequestMapping(value = "/getRole2", method = RequestMethod.GET)
    public ModelAndView getRoleByJson(@RequestParam("id") int id){
        Role role = roleService.getRole(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role", role);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }
}
