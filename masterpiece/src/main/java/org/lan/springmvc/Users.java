package org.lan.springmvc;
public class Users {  
    private String name;  
    private String password;  
    
  
    public String toString() {  
        return "Users [name=" + name + ", password=" + password +  "]";  
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}  
}  