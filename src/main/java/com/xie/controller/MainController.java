package com.xie.controller;

import com.xie.bean.User;
import com.xie.controller.api.BaseController;
import com.xie.request.UserRegisterDto;
import com.xie.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by xie on 17/1/7.
 */
@Controller
public class MainController extends BaseController implements ErrorController{

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = {"/", "/index", "index.html"}, method = RequestMethod.GET)
    public String index(Model model) {
        setHeaderData(model);
        model.addAttribute("title", "首页");
        return "index";
    }

    @RequestMapping(value = {"/login", "login.html"}, method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "登录");
        return "login";
    }

    @RequestMapping(value = {"/register", "register.html"}, method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("title", "注册");
        return "register";
    }

    @RequestMapping(value = {"/logout", "logout.html"}, method = RequestMethod.GET)
    public String logout(Model model) {
        model.addAttribute("title", "退出");
        return "logout";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        setHeaderData(model);
        model.addAttribute("title", "个人中心");
        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(@Valid UserRegisterDto userRegisterDto, Model model) {
        if (userService.checkUsername(userRegisterDto.getUsername()) > 0) {
            model.addAttribute("name.exists", "用户名或者手机号已经存在");
            return "/register";
        }
        User user = new User();
        user.setUsername(userRegisterDto.getUsername());
        user.setCreatedAt(DateTime.now().toDate());
        user.setUserLevelId((byte) 1);
        user.setPassword(bCryptPasswordEncoder.encode(userRegisterDto.getPassword()));

        userService.insert(user);
        return "redirect:/index";
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
