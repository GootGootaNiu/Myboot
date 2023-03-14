package com.king.myboot.controller;

import com.king.myboot.MybootApplication;
import com.king.myboot.pojo.User;
import com.king.myboot.service.UserService;
import com.king.myboot.utils.ValidateImageCodeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/code")
    public void valida(HttpSession session, HttpServletResponse response) throws IOException {
        // 使用验证码的工具类 生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //生成验证码图片  在吧生成的验证码放入到图片中去
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //把生成的验证码放到域中去
        session.setAttribute("code", securityCode);//把生成的验证码放到域中去
        // 响应图片
        // 通过流的方式响应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

    @PostMapping("/acton")
    public String acton(User user , String code , HttpSession session,Model model) {
        // 这里拿到session中的数据code
        String sessionCode =(String) session.getAttribute("code");
        // 这里是让session中的code  和用户输入的code进行比较
        if (code.equalsIgnoreCase(sessionCode)){
            // 正确的话返回到的页面
            userService.insertAll(user);
            return "redirect:/cont/login"; // 重定向到index 页面上
        }else {
           model.addAttribute("msg","验证码不正确,请重新输入");
            // 返回到注册页面
            return "redirect:/cont/regist";
        }
    }

    @PostMapping("/login")
    public String login(String username,String password){
        User login = userService.selectAll(username, password);
        if (login!=null){
            return "redirect:/emp/selectEmp"; //登录成功跳
        }else {
            return "redirect:/cont/login"; //登录失败还是登录页面
        }
    }

}





























