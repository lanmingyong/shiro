package com.guoxin.module.system.controller;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.guoxin.common.base.Constants;
import com.guoxin.module.system.entity.Users;
import com.guoxin.module.system.service.IUserService;

/**
 * 用户登录登出控制层
 * @author Rocye
 * @createTime 2014-10-14
 */
@Controller
public class LoginController {
    
    private final static Logger logger = Logger.getLogger(LoginController.class.getName());
    
    @Resource
    private IUserService userService;
    
    /**
     * 用户登陆系统	
     * @author Rocye
     * @createTime 2015-10-13
     */
    @RequestMapping(value="/goLogin", method=RequestMethod.POST)
    public String login(@ModelAttribute("user") Users user, HttpSession session, final RedirectAttributes attr){
        try{
            if (user.getLoginName() == null || "".equals(user.getLoginName().trim()) || user.getPassword() == null || "".equals(user.getPassword().trim())) {
                attr.addFlashAttribute("msg", "登录名或密码不能为空!");
                return "redirect:/login";
            } else {
                Map<String, Object> resultMap = this.userService.loginSystemByUser(user);
                if(Integer.parseInt(resultMap.get("msgid").toString()) == 0){
                    attr.addFlashAttribute("msg", resultMap.get("msg").toString());
                    return "redirect:/login";
                }else{
                    session.setAttribute(Constants.LOGIN_KEY, resultMap.get("user"));
                    return "redirect:/user/list";
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("登录系统时出错:" + e.toString());
            attr.addFlashAttribute("msg", "发生错误，请联系管理员！");
            return "redirect:/login";
        }
    }
    
    /**
     * Shiro登陆系统	
     * @author Rocye
     * @createTime 2016-12-03
     */
    //RedirectAttributes是Spring mvc 3.1版本之后出来的一个功能，专门用于重定向之后还能带参数跳转的
    //attr.addFlashAttribute("param", value);这种方式也能达到重新向带参，而且能隐藏参数，
    //其原理就是放到session中，session在跳到页面后马上移除对象。所以你刷新一下后这个值就会丢掉
    @RequestMapping(value="/doLogin")
    public String doLogin(@ModelAttribute("user") Users user, HttpServletRequest request, HttpSession session, final RedirectAttributes attr){
        try{
            if (user.getLoginName() == null || "".equals(user.getLoginName().trim()) || user.getPassword() == null || "".equals(user.getPassword().trim())) {
                attr.addFlashAttribute("msg", "登录名或密码不能为空!");
                return "redirect:/login";
            } else {
            	//收集实体/凭据信息
            	//你可以自己设置一个标志位，然后根据这个标志位判断一下用户是否勾选了记住我，如果勾选了就使用 token.setRememberMe(true) 设置为记住我。
            	UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
            	System.out.println("用户名："+user.getLoginName()+" 密码："+user.getPassword());
            	if(request.getParameter("rememberMe") != null){
            		token.setRememberMe(true);  
            	}
            	//收集了实体/凭据信息之后，我们可以通过SecurityUtils工具类，获取当前的用户，然后通过调用login方法提交认证
                Subject subject = SecurityUtils.getSubject();
                String msg = "";
                try {  
                    subject.login(token);
                    //验证用户是否为认证用户
                    if (subject.isAuthenticated()) {  
                        return "redirect:/user/list";
                    } else {  
                        return "redirect:/login";
                    }  
                    //验证失败，提示信息
                } catch (IncorrectCredentialsException e) {  
                    msg = "登录密码错误！";  
                    logger.error("Password for account " + token.getPrincipal() + " was incorrect.");  
                } catch (ExcessiveAttemptsException e) {  
                    msg = "登录失败次数过多！";  
                    logger.error("Login for account " + token.getPrincipal() + " had too many times.");
                } catch (LockedAccountException e) {  
                    msg = "帐号已被锁定！";  
                    logger.error("The account for username " + token.getPrincipal() + " was locked.");
                } catch (DisabledAccountException e) {  
                    msg = "帐号已被禁用！";  
                    logger.error("The account for username " + token.getPrincipal() + " was disabled.");
                } catch (ExpiredCredentialsException e) {  
                    msg = "帐号已过期！";  
                    logger.error("The account for username " + token.getPrincipal() + "  was expired.");
                } catch (UnknownAccountException e) {  
                    msg = "帐号不存在！";
                    logger.error("There is no user with username of " + token.getPrincipal());
                } catch (UnauthorizedException e) {  
                    msg = "您没有得到相应的授权！";  
                    System.out.println(msg);
                    logger.error("The account for username " + token.getPrincipal() + " was not Permission.");
                }  
                attr.addFlashAttribute("msg", msg);
                return "redirect:/login";
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("登录系统时出错:" + e.toString());
            attr.addFlashAttribute("msg", "发生错误，请联系管理员！");
            return "redirect:/login";
        }
    }
    
    /**
     * 跳转用户登录页面
     * @author Rocye
     * @createTime 2015-10-13
     */
    @RequestMapping(value="/login")
    public String index(){
        return "../index";
    }
    
    /**
     * 没有权限访问时跳转的提示页面
     * @author Rocye
     * @createTime 2016-12-06
     */
    @RequestMapping(value="/403")
    public String unauth(){
        return "403";
    }
    
    /**
     * 登录超时提示页
     * @author Rocye
     * @createTime 2015-10-13
     */
    @RequestMapping(value="/timeout")
    public String loginTimeout(Model model){
        model.addAttribute("msg", "用户登录信息已超期, 请重新登录！");
        model.addAttribute("url", "index");
        return "error-login";
    }
    
    /**
     * 注销用户登录
     * @author Rocye
     * @createTime 2016-12-05
     */
    @RequestMapping(value="/logout")
    public String logout(){
    	Subject subject = SecurityUtils.getSubject();
    	Object loginName = subject.getPrincipal();
    	if(subject.isAuthenticated()){
    		subject.logout();
    		logger.warn(loginName + "退出登录！");
    	}
    	return "../index";
    }
    
}
