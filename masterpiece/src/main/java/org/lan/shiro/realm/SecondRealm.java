package org.lan.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class SecondRealm extends AuthenticatingRealm {


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("SecondRealm----->doGetAuthenticationInfo");
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
            credentials="ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
        }else if ("user".equals(username)){
            credentials="073d4c3ae812935f23cb3f2a71943f49e082a718";
        }
        String realmName=getName();
        SimpleAuthenticationInfo info ;//new SimpleAuthenticationInfo(principal,credentials,realmName);
        ByteSource credentialsSalt=ByteSource.Util.bytes(username);
        info=new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);



        return info;
    }


}
