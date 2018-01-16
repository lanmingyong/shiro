package org.lan.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lan.mybatis.dao.StudentMapper;
import org.lan.mybatis.domain.Student;
import org.lan.utils.SqlSessionFactoryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentBatchTest {
  
    private static Logger logger=Logger.getLogger(Student.class);
    private SqlSession sqlSession=null;
    private StudentMapper studentMapper=null;
      
    /** 
     * 测试方法前调用 
     * @throws Exception 
     */  
    @Before
    public void setUp() throws Exception {  
        sqlSession= SqlSessionFactoryUtil.openSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);  
    }  
  
    /** 
     * 测试方法后调用 
     * @throws Exception 
     */  
    @After
    public void tearDown() throws Exception {  
        sqlSession.close();  
    }  
      
    //通过list进行批量插入  
    @Test
    public void batchInsertStudentWithList(){  
          List<Student> list= new ArrayList<Student>();
            for(int i = 2;i < 10;i++){  
                Student student = new Student();  
                student.setName("test" + i);  
                list.add(student);  
            }  
            int n=studentMapper.batchInsertStudentWithList(list);  
            System.out.println("成功插入"+n+"条记录");  
            sqlSession.commit();  
    }  
    //分页批量插入  
    @Test  
    public void batchInsertStudentPage(){  
        List<Student> list= new ArrayList<Student>();  
        for(int i = 0;i < 2000;i++){  
            Student student = new Student();  
            student.setName("test" + i);  
            list.add(student);  
        }  
        try {  
            save(list);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    private void save(List<Student> uidCodeList) throws Exception {  
        SqlSession batchSqlSession = null;  
        try {  
            batchSqlSession =SqlSessionFactoryUtil.openSession();//获取批量方式的sqlsession          
            int batchCount = 1000;//每批commit的个数  
            int batchLastIndex = batchCount - 1;//每批最后一个的下标  
            for(int index = 0; index < uidCodeList.size()-1;){  
                if(batchLastIndex > uidCodeList.size()-1){  
                    batchLastIndex = uidCodeList.size() - 1;  
                    batchSqlSession.insert("org.lan.mybatis.dao.StudentMapper.batchInsertStudentWithList", uidCodeList.subList(index, batchLastIndex+1));  
                    batchSqlSession.commit();  
                    System.out.println("index:"+index+"     batchLastIndex:"+batchLastIndex);  
                    break;//数据插入完毕,退出循环  
                      
                }else{  
                    batchSqlSession.insert("org.lan.mybatis.dao.StudentMapper.batchInsertStudentWithList", uidCodeList.subList(index, batchLastIndex+1));                                   batchSqlSession.commit();  
                    System.out.println("index:"+index+"     batchLastIndex:"+batchLastIndex);  
                    index = batchLastIndex + 1;//设置下一批下标  
                    batchLastIndex = index + (batchCount - 1);                        
                }                 
            }                         
        }finally{  
            batchSqlSession.close();  
        }         
    }  
    //通过IdList批量更新  
    @Test  
    public void batchUpdateByIdList() {  
        logger.info("通过IdList批量更新");  
        List<Integer> list = new ArrayList<Integer>();  
        list.add(5);  
        list.add(6);  
        int n = studentMapper.batchUpdateByIdList(list);  
        System.out.println("成功更新" + n + "条记录");  
        sqlSession.commit();  
    }  
  
    //通过map进行批量更新  
    @Test  
    public void batchUpdateStudentWithMap() {  
        List<Integer> ls = new ArrayList<Integer>();  
        for (int i = 5; i < 7; i++) {  
            ls.add(i);  
        }  
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idList", ls);  
        map.put("name", "小群11");  
        int n = studentMapper.batchUpdateStudentWithMap(map);  
        System.out.println("成功更新" + n + "条记录");  
        sqlSession.commit();  
    }  
    //通过list批量更新  
    @Test  
    public void batchUpdateStudentWithList() {  
        logger.info("更新学生(带条件)");  
        List<Student> list = new ArrayList<Student>();  
        list.add(new Student(6, "张三aa"));  
        list.add(new Student(6, "李四aa"));  
        int n = studentMapper.batchUpdateStudentWithList(list);  
        System.out.println("成功更新" + n + "条记录");  
        sqlSession.commit();  
    }  
      
    //通过Array进行批量删除  
    @Test  
    public void batchDeleteStudentWithArray() {  
        logger.info("删除学生，通过Array");  
        int array[] = new int[] { 3, 4 };  
        studentMapper.batchDeleteStudentWithArray(array);  
        sqlSession.commit();  
    }  
    @Test  
    public void batchDeleteStudentWithIdList() {  
        logger.info("通过IdList批量更新");  
        List<Integer> list = new ArrayList<Integer>();  
        list.add(9);  
        list.add(10);  
        int n = studentMapper.batchDeleteStudentWithIdList(list);  
        System.out.println("成功删除" + n + "条记录");  
        sqlSession.commit();  
    }  
    @Test  
    public void batchDeleteStudentWithList() {  
        logger.info("通过IdList批量更新");  
        List<Student> list = new ArrayList<Student>();  
        list.add(new Student(12, null));  
        list.add(new Student(13, null));  
        int n = studentMapper.batchDeleteStudentWithList(list);  
        System.out.println("成功删除" + n + "条记录");  
        sqlSession.commit();  
    }  
      
    @Test  
    public void batchDeleteStudentWithListOnlyId() {  
        logger.info("通过IdList批量更新");  
        List<Student> list = new ArrayList<Student>();  
        list.add(new Student(14, null));  
        list.add(new Student(15, null));  
        int n = studentMapper.batchDeleteStudentWithListOnlyId(list);  
        System.out.println("成功删除" + n + "条记录");  
        sqlSession.commit();  
    }  
      
}  