package org.lan.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm extends AuthenticatingRealm {


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("FirstRealm----->doGetAuthenticationInfo");
        UsernamePasswordToken upToken=(UsernamePasswordToken)token;
        String username=upToken.getUsername();
        if ("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在！");
        }
        if ("locked".equals(username)) {

            throw new LockedAccountException("用户被锁定！");
        }
        String principal=username;
        Object credentials=null;
        if ("admin".equals(username)){
            credentials="038bdaf98f2037b31f1e75b5b4c9b26e";
        }else if ("user".equals(username)){
            credentials="098d2c478e9c11555ce2823231e02ec1";
        }
        String realmName=getName();
        SimpleAuthenticationInfo info ;//new SimpleAuthenticationInfo(principal,credentials,realmName);
        ByteSource credentialsSalt=ByteSource.Util.bytes(username);
        info=new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);



        return info;
    }


}
