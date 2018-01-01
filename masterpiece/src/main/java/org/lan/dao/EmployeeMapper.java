package org.lan.dao;

import java.util.HashMap;
import java.util.List;

import org.lan.pojo.Employee;

public interface EmployeeMapper {
public List<Employee> selectEmployeeByIdLike(HashMap<String, Object> params);
public List<Employee> selectEmployeeChoose(HashMap<String, Object> params);
public Employee selectEmployeeWithId(Integer id);
public void updateEmployeeIfNecessary(Employee employee);
//根据传入的id集合查询员工
//该方法的参数是一个LIST集合，该集合中的每一个Integer元素表示要查询员工的id
public List<Employee> selectEmployeeIn(List<Integer> ids);

//根据传入的参数进行模糊查询
public List<Employee> selectEmloyeeLikeName(Employee employee);

}
