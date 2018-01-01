package org.lan.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
private static SqlSessionFactory factory;
static {
	try {
		InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
		factory=new SqlSessionFactoryBuilder().build(is);
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public static SqlSession createSqlsession() {
	return factory.openSession(true);
}
public static void closeSqlSession(SqlSession sqlSession) {
	if(null!=sqlSession) {
		sqlSession.close();
	}
}
}
