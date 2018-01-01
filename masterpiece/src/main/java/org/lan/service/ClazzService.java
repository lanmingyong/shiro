package org.lan.service;

import org.apache.ibatis.session.SqlSession;

import org.lan.dao.ClazzMapper;
import org.lan.pojo.Clazz;
import org.lan.util.MybatisUtils;

public class ClazzService {
private SqlSession sqlSession =MybatisUtils.createSqlsession();
private ClazzMapper clazzMapper=sqlSession.getMapper(ClazzMapper.class);
public Clazz selectClazzById(Integer id) {
	return clazzMapper.selectClazzById(id);
}
}
