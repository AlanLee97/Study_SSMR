package com.study.controller;

import com.study.pojo.Role;
import com.study.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 测试保存并获取参数
 * RequestAttribute
 * SessionAttribute 读取session属性
 * SessionAttributes 设置session属性
 */
@Controller
@RequestMapping("/attr")
//配置数据模型 名称和类型
@SessionAttributes(names = {"id"}, types = {Role.class})
public class AttributeController {
    AttributeController(){
        System.out.println("进入AttributeController控制器");
    }

    @Autowired
    private RoleService roleService = null;
    private ModelAndView modelAndView = new ModelAndView();
    private Role role = null;

    /**
     * 使用RequestAttribute
     */
    @RequestMapping("/reqAttr")
    public ModelAndView reqAttr(@RequestAttribute("id") int id){
        roleService.getRole(id);
        modelAndView.addObject("role",role);
        modelAndView.setView(new MappingJackson2JsonView());

        return modelAndView;
    }

    /**
     * 使用SessionAttribute 读取session属性
     */
    @RequestMapping("/sessAttr")
    public ModelAndView sessAttr(@SessionAttribute("id") int id){
        Role role = roleService.getRole(id);
        modelAndView.addObject("role", role);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }

    /**
     * 使用SessionAttribute 设置session属性
     */
    @RequestMapping("/sessAttrs")
    public ModelAndView sessAttrs(int id){
        Role role = roleService.getRole(id);
        modelAndView.addObject("role", role);
        modelAndView.addObject("id",id);
        modelAndView.setViewName("sessionAttributes");
        return modelAndView;
    }

}
