package com.study.controller;

import com.study.pojo.Role;
import com.study.pojo.RoleParams;
import com.study.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Controller
@RequestMapping(value = "/params")
public class ParamsController {
    public ParamsController() {
        System.out.println("进入ParamsController控制器");
    }

    @Autowired
    private RoleService roleService = null;

    /**
     * 普通请求参数
     * @param roleName
     * @param note
     * @return
     */
    @RequestMapping("/commonsParamsPojo")
    public ModelAndView commonsParamsPojo(String roleName, String note){
        System.out.println("roleName: " + roleName);
        System.out.println("note: " + note);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }

    /**
     * 使用URL传递参数
     */
    //{id}代表接收一个参数
    @RequestMapping("/url/{id}")
    public ModelAndView urlParams(@PathVariable("id") int id){
        Role role = roleService.getRole(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(role);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }

    /**
     * 传递json参数
     */
    @RequestMapping("/findRoles")
    public ModelAndView jsonParams(@RequestBody RoleParams roleParams){
        List<Role> roleList = roleService.findRoles(roleParams);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(roleList);
        modelAndView.setView(new MappingJackson2JsonView());

        return modelAndView;
    }

    /**
     * 传递数组，批量删除用户
     */
    @RequestMapping("/deleteRoles")
    public ModelAndView deleteRoles(@RequestBody List<Integer> idList){
        System.out.println("进入deleteRoles");
        int total = roleService.deleteRoles(idList);
        System.out.println(total);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("total",total);
        modelAndView.setView(new MappingJackson2JsonView());

        return modelAndView;
    }


    /**
     * 传递数组，新增角色
     */
    @RequestMapping("/addRoles")
    public ModelAndView insertRoles(@RequestBody List<Role> roleList){
        int total = roleService.insertRoles(roleList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("total", total);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }

    /**
     * 测试序列化方式提交
     */
    @RequestMapping("/commonParamPojo2")
    public ModelAndView commonParamPojo2(String roleName, String note) {
        System.out.println("roleName =>" + roleName);
        System.out.println("note =>" + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }



}
