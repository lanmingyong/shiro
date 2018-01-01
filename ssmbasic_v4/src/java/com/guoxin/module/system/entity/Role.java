package com.guoxin.module.system.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色信息 Entity
 * @author Corey
 * @createTime 2016-12-03
 */
public class Role implements Serializable{
	private static final long serialVersionUID = 3860482960780386530L;
	
	private Integer id;           //ID
    private String token;         //标识
    private String name;          //名称
    
    private List<Permission> permissions;
 
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }
    
    public String getToken() {  
        return token;  
    }  
    public void setToken(String token) {  
        this.token = token;  
    }
    
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }
    
    public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	/**
	 * 获取PermissionSet
	 */
	public Set<String> getPermissionSet(){
		Set<String> permissionSet = new HashSet<String>();
		for(Permission permission : permissions){
			permissionSet.add(permission.getToken());
		}
		return permissionSet;
	}
}
