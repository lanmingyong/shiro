package org.lan.pojo;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -9095288917057294814L;
	private Integer id;
	private String sex;
	private Integer age;
	private String name;
	private Clazz clazz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sex=" + sex + ", age=" + age + ", name=" + name + ", clazz=" + clazz + "]";
	}
	
}
