package org.lan.mybatis.dao;

import org.lan.mybatis.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /** 
     * 通过List集合批量插入 
     * @param list 
     * @return 
     */  
    public int batchInsertStudentWithList(List<Student> list);
    /** 
     * 通过IdList进行Update特定字段为特定值 
     * @param list 
     * @return 
     */  
    public int batchUpdateByIdList(List<Integer> list);  
    /** 
     * 通过Map批量更新 
     * @param map 
     * @return 
     */  
    public int batchUpdateStudentWithMap(Map<String, Object> map);
    /** 
     * 通过List集合批量更新 
     * @param list 
     * @return 
     */  
    public int batchUpdateStudentWithList(List<Student> list);  
      
    /** 
     * 通过数组进行批量删除 
     * @param array 
     * @return 
     */  
    public int batchDeleteStudentWithArray(int array[]);  
    /** 
     * 能过IdList进行批量删除 
     * @param list 
     * @return 
     */  
    public int batchDeleteStudentWithIdList(List<Integer> list);  
    /** 
     * 通过list删除 
     * @param list 
     * @return 
     */  
    public int batchDeleteStudentWithList(List<Student> list);  
    /** 
     * 通过list中对象进行删除 
     * @param list 
     * @return 
     */  
    public int batchDeleteStudentWithListOnlyId(List<Student> list);  
}  