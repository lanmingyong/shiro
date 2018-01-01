package org.lan.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.Scanner;

/**
 * 如何使用Shiro在Java中进行身份验证
 */
public class AuthenticationTest {

    public static void  main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("请输入用户名:");
        String username=input.nextLine();
        System.out.print("请输入密码:");
        String password=input.nextLine();

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //获得用户名和密码,创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken( username, password );
        //我们使用Shiro内置的“记住我”功能，通过在令牌上设置为true。这是使用令牌的setRememberMe()方法完成的
        token.setRememberMe(true);
        //我们需要获取当前正在执行的用户，称为主题。
        //为了获得这个主题，我们使用了SecurityUtils类。它将通过getsubject()方法调用获取当前正在执行的用户.
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //我们通过调用login()方法来验证它们，并提交我们刚刚构建的令牌。
            currentUser.login(token);

        } catch (UnknownAccountException uae) {//账号不存在异常

            System.out.println("账号不存在");

        } catch (IncorrectCredentialsException ice) {//当输入密码错误会抛此异常

            System.out.println("密码错误");

        } catch (LockedAccountException lae) {//帐号被锁定

            System.out.println("帐号被锁定");

        } catch (DisabledAccountException ae) {//帐号被禁用

            System.out.println("帐号被禁用");

        } catch (ExcessiveAttemptsException ae) {//登录失败次数过多

            System.out.println("登录失败次数过多");

        } catch (ExpiredCredentialsException ae) {//凭证过期

            System.out.println("凭证过期");

        }
        //注销Shiro，它将关闭用户会话，并从主题实例中删除任何关联的身份
        currentUser.logout();
    }
}
