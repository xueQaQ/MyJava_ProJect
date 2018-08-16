package com.bittech.javaweb.control;

import com.bittech.javaweb.entity.User;
import com.bittech.javaweb.service.UserService;
import com.bittech.javaweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Author: secondriver
 * Created: 2018/8/6
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    
    protected static final String CURRENT_USER = "currentUser";
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
    public String login() {
        return "index";
    }
    
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ModelAndView login(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "password") String password,
            HttpSession session
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", userName);
        modelAndView.addObject("password", password);
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
            modelAndView.addObject("error", "用户名或密码为空！");
            modelAndView.setViewName("index");
        } else {
            User user = new User();
            user.setPassword(password);
            user.setUserName(userName);
            boolean loginResult = userService.login(user);
            if (loginResult) {
                session.setAttribute(CURRENT_USER, user);
                modelAndView.setViewName("main");
            } else {
                modelAndView.addObject("error", "用户名或密码错误！");
                modelAndView.setViewName("index");
            }
        }
        return modelAndView;
    }
    
    
    @RequestMapping(value = {"/register"}, method = {RequestMethod.GET})
    public String register() {
        return "register";
    }
    
    @RequestMapping(value = {"/register"}, method = {RequestMethod.POST})
    protected ModelAndView register(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "passwordAgain") String passwordAgain,
            HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", userName);
        modelAndView.addObject("password", password);
        
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(passwordAgain)) {
            modelAndView.addObject("error", "用户名或密码为空！");
            modelAndView.setViewName("register");
        } else if (!password.equals(passwordAgain)) {
            modelAndView.addObject("error", "两次密码不一致！");
            modelAndView.setViewName("register");
        } else {
            User user = new User();
            user.setPassword(password);
            user.setUserName(userName);
            boolean loginResult = userService.register(user);
            if (loginResult) {
                session.setAttribute(CURRENT_USER, user);
                modelAndView.setViewName("main");
            } else {
                modelAndView.addObject("error", "用户名已经存在！");
                modelAndView.setViewName("register");
            }
        }
        return modelAndView;
        
    }
    
    
    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public String logout(HttpSession session) {
        session.removeAttribute(CURRENT_USER);
        // 客户端跳转
        return "index";
    }
}
