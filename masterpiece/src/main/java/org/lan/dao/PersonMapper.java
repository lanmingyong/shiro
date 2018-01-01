package org.lan.dao;

import org.lan.pojo.Person;

public interface PersonMapper {
	//查询所有的人
public Person selectPersonById(Integer id);
}
