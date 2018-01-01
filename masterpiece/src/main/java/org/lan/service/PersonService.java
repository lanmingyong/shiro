package org.lan.service;

import org.apache.ibatis.session.SqlSession;

import org.lan.dao.PersonMapper;
import org.lan.pojo.Person;
import org.lan.util.MybatisUtils;

public class PersonService {
 SqlSession sqlSession=MybatisUtils.createSqlsession();
 PersonMapper personMapper=sqlSession.getMapper(PersonMapper.class);
public Person selectPersonById(Integer id) {
	return personMapper.selectPersonById(id);
	
}
}
