package org.lan.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.lan.dao.EmployeeMapper;
import org.lan.pojo.Employee;
import org.lan.util.MybatisUtils;

public class EmployeeService {
	private SqlSession sqlSession=MybatisUtils.createSqlsession();
	private EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
public  List<Employee> selectEmployeeByIdLike(HashMap<String,Object> params){
	return employeeMapper.selectEmployeeByIdLike(params);
}
public List<Employee> selectEmployeeChoose(HashMap<String,Object> params){
	return employeeMapper.selectEmployeeChoose(params);
}
public Employee selectEmployeeWithId(Integer id){
	return employeeMapper.selectEmployeeWithId( id);


}
public void updateEmployeeIfNecessary(Employee employee) {
	 employeeMapper.updateEmployeeIfNecessary( employee);
}

public List<Employee> selectEmployeeIn(List<Integer> ids){
	return employeeMapper.selectEmployeeIn(ids);
}

public List<Employee> selectEmployeeLikeName(Employee employee){
	return employeeMapper.selectEmloyeeLikeName(employee);
}
}
