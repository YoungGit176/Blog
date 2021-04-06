package com.young.blog.controller.admin;

import com.young.blog.pojo.User;
import com.young.blog.service.serviceImpl.UserServiceImpl;
import com.young.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping
    public String loginPage(){
        System.out.println("--------------------------");
        return "admin/login";
    }

    @RequestMapping("/login")
    public String login(User user,
                        HttpSession session){
        user = userService.checkUser(user.getUsername());
        /*user.setPassword(null);*/
        System.out.println(user);
        session.setAttribute("user",user);
        System.out.println("通往index");
        return "admin/index";
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        System.out.println("通过logout");
        return "redirect:/admin";
    }
}
