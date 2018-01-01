package org.lan.dao;


import java.util.List;

import org.lan.pojo.Student;

public interface StudentMapper {
	//查询班级里全部的学生的信息
public List<Student> selectStudentByClazzId(Integer clazz_id);
 	//查询某个学生的信息
public Student selectStudentById(Integer student_id);
}
