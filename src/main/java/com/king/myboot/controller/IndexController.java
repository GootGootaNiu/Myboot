package com.king.myboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ValueExp;

/**
 * @author huanm
 * <p>
 * thymeleaf所有操作都需要通过controller实现跳转
 */
@Controller
@RequestMapping("/cont")
public class IndexController {
    // 进入到login.html 页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    //进入到注册页面
    @RequestMapping ("/regist")
    public String regist(){
        return "regist";
    }


}
