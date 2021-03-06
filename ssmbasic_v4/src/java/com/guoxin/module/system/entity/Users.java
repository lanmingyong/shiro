package com.guoxin.module.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 系统用户 Entity
 * @author Rocye
 * @createTime 2013-08-25
 */
public class Users implements Serializable{
    
    private static final long serialVersionUID = 6552288028399525389L;
    
    private Integer userId;				    //主键ID
	private String loginName;				//登录名
	private String password;				//密码
	private String userName;				//姓名
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date birthday;             		//生日
	private String userPhone;				//手机
	private String userEmail;				//邮箱
	private String headImg;                 //头像
	private Boolean deleteFlag;				//删除标记
	
	private List<Role> roleList;
	
	public Users() {
    }

    public Users(String loginName, String password, String userName,String userPhone, String userEmail, Boolean deleteFlag) {
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.deleteFlag = deleteFlag;
    }

    public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getHeadImg() {
        return headImg;
    }
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * 获取Shiro能用的角色Set
	 */
	public Set<String> getRoleSet(){
		Set<String> roleSet = new HashSet<String>();
		for(Role role : roleList){
			roleSet.add(role.getToken());
		}
		return roleSet;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", loginName=" + loginName + ", password=" + password + ", userName="
				+ userName + ", birthday=" + birthday + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", headImg=" + headImg + ", deleteFlag=" + deleteFlag + ", roleList=" + roleList + "]";
	}
	
}
