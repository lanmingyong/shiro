package org.lan.service;

import org.apache.ibatis.session.SqlSession;

import org.lan.dao.UsersMapper;
import org.lan.pojo.Users;
import org.lan.util.MybatisUtils;

public class UsersService {
private SqlSession sqlSession=MybatisUtils.createSqlsession();
private UsersMapper usersMapper=sqlSession.getMapper(UsersMapper.class);
public Users selectUserById(Integer id) {
	return usersMapper.selectUserById(id);
	
}
}
