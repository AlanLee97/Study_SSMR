package com.study.controller;

import com.study.pojo.Role;
import com.study.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/role")
public class RoleController {
    RoleController(){
        System.out.println("进入RoleController");
    }

    @Autowired
    private RoleService roleService = null;

    /**
     * 将信息转换为json视图
     * @return
     */
    @RequestMapping("/showJsonInfo")
    public ModelAndView showJsonInfo(int id, String roleName, String note){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        modelAndView.addObject("id", id);
        modelAndView.addObject("roleName", roleName);
        modelAndView.addObject("note", note);


        return modelAndView;
    }

    /**
     * 将信息转换为json视图2
     */
    @RequestMapping("/showJsonInfo2")
    public ModelAndView showJsonInfo2(Role role){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        modelAndView.addObject("role", role);
        return modelAndView;
    }


    /**
     * 重定向：通过字符串来重定向
     */
    @RequestMapping("/addRole")
    public String addRole(Model model, String roleName, String note){
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);
        roleService.insertRole(role);

        //绑定重定向数据模型
        model.addAttribute("roleName",roleName);
        model.addAttribute("note",note);
        model.addAttribute("id",role.getId());

        return "redirect:./showJsonInfo.do";
    }


    /**
     * 重定向：通过视图来重定向
     */
    @RequestMapping("/addRole2")
    public ModelAndView addRole2(Model model, String roleName, String note){
        ModelAndView modelAndView = new ModelAndView();
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);
        roleService.insertRole(role);

        //绑定重定向数据模型
        model.addAttribute("roleName",roleName);
        model.addAttribute("note",note);
        model.addAttribute("id",role.getId());

        //通过视图来重定向
        modelAndView.setViewName("redirect:./showJsonInfo");

        return modelAndView;
    }

    /**
     * 使用flash属性传递对象参数
     * @return
     */
    @RequestMapping("/addRole3")
    public String addRole3(RedirectAttributes redirectAttributes, Role role){
        roleService.insertRole(role);
        //绑定重定向数据模型
        redirectAttributes.addAttribute("role", role);

        return "redirect:./showJsonInfo2";
    }


    /**
     * 测试数据模型======================
     * 数据模型：
     * ModelMap
     * Model
     * ModelAndView
     */

    /**
     * 使用数据模型ModelMap
     */
    @RequestMapping(value = "/getRoleByModelMap", method = RequestMethod.GET)
    public ModelAndView getRoleByModelMap(@RequestParam("id") int id, ModelMap modelMap){
        Role role = roleService.getRole(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleDetails");
        modelMap.addAttribute("role",role);
        return modelAndView;
    }

    /**
     * 使用数据模型Model
     */
    @RequestMapping(value = "/getRoleByModel", method = RequestMethod.GET)
    public ModelAndView getRoleByModel(@RequestParam("id") int id, Model model){
        Role role = roleService.getRole(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleDetails");
        model.addAttribute("role",role);
        return modelAndView;
    }

    /**
     * 使用数据模型ModelAndView
     */
    @RequestMapping(value = "/getRoleByModelAndView", method = RequestMethod.GET)
    public ModelAndView getRoleByModelAndView(@RequestParam("id") int id, ModelAndView modelAndView){
        Role role = roleService.getRole(id);
        modelAndView.setViewName("roleDetails");
        modelAndView.addObject("role",role);
        return modelAndView;
    }
}
