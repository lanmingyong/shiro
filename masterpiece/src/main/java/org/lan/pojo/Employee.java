package org.lan.pojo;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1979462000388438536L;
	private Integer id;
	private String loginname;
	private String password;
	private String name;
	private String sex;
	private Integer age;
	private String phone;
	private Double sal; //薪水
	private String state; //状态
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getloginname() {
		return loginname;
	}
	public void setloginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", loginname=" + loginname + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", age=" + age + ", phone=" + phone + ", sal=" + sal + ", state=" + state + "]";
	}
	
}
