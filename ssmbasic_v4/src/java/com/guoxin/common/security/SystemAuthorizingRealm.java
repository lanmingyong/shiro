package com.guoxin.common.security;

import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;
import com.guoxin.common.util.MD5;
import com.guoxin.common.util.Utilities;
import com.guoxin.module.system.dao.IUserDao;
import com.guoxin.module.system.entity.Role;
import com.guoxin.module.system.entity.Users;

@Service("systemAuthorizingRealm")
public class SystemAuthorizingRealm extends AuthorizingRealm {

	@Resource
	private IUserDao userDao;
	
	/**
	 * 权限验证
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取登录时输入的用户名  
        String loginName = (String)principals.fromRealm(getName()).iterator().next();
        System.out.println("---------------->2222" + loginName);
        //到数据库查是否有此对象  
        Users dbUser = new Users();
        dbUser.setDeleteFlag(false);
        dbUser.setLoginName(loginName);
        List<Users> userList = this.userDao.getUserList(dbUser);
        if(userList.size() > 0){
        	Users user = userList.get(0);
        	//权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合  
            info.setRoles(user.getRoleSet());  
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
            List<Role> roleList = user.getRoleList();  
            for (Role role : roleList) {  
                info.addStringPermissions(role.getPermissionSet());  
            }  
            return info;  
        }
        return null;  
	}

	/**
	 * 登录验证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String loginame = upToken.getUsername().trim();
		String password = new String(upToken.getPassword());
		
		
		Users dbUser = new Users();
        dbUser.setDeleteFlag(false);
        dbUser.setLoginName(loginame);
        List<Users> userList = this.userDao.getUserList(dbUser);
        for (Users users : userList) {
			System.out.println("users=="+users);
		}
		if(userList.size() > 0){
			dbUser = userList.get(0);
			//使用 toUpperCase() 来把字符串转换成大写
            String upValue = MD5.encode(Utilities.encryptPassword(loginame, password)).toUpperCase();
            //使用toLowerCase() 来把字符串转换成小写
            String lowerValue = MD5.encode(Utilities.encryptPassword(loginame, password)).toLowerCase();
            System.out.println("upValue=="+upValue+"\t"+"lowerValue=="+lowerValue);
            if (dbUser.getPassword().equals(upValue) || dbUser.getPassword().equals(lowerValue)) {
            	return new SimpleAuthenticationInfo(loginame, password, getName());
            }else{
            	throw new IncorrectCredentialsException("登录密码错误.");
            }
		}else{
			return null;
		}
	}

}
