package org.lan.shiro.controller;

import org.lan.shiro.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class ShiroController {

    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/testShiroAnnotation")
    public String testShiroAnnotation(){
        shiroService.testMethod();
        return "redirect:/list.jsp";
    }

    @RequestMapping("/login")
    public String userLogin(@RequestParam String username,@RequestParam String password){
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token= new UsernamePasswordToken(username,password);
            token.setRememberMe(true);
            try {

                currentUser.login(token);
            }catch (AuthenticationException ae){
                System.out.println("用户"+token.getUsername()+"登录失败!");
                ae.printStackTrace();
            }
        }
        return "redirect:/list.jsp";
    }
}
