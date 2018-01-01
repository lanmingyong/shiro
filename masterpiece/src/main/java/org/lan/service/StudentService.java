package org.lan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.lan.dao.StudentMapper;
import org.lan.pojo.Student;
import org.lan.util.MybatisUtils;

public class StudentService {
private SqlSession sqlSession=MybatisUtils.createSqlsession();
private StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
public List<Student> selectStudentByClazzId(Integer clazz_id){
	return studentMapper.selectStudentByClazzId(clazz_id);
}
public Student selectStudentById(Integer student_id) {
	return studentMapper.selectStudentById(student_id);
}
}
