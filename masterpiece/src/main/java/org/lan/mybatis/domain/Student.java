package org.lan.mybatis.domain;

import java.io.Serializable;

public class Student implements Serializable {
  
    private Integer id;  
    private String name;  
    private byte[] pic;// blob  
    private String remark;// clob
    public Student() {  
        super();  
    }
  
    public Student(Integer id, String name) {  
        super();  
        this.id = id;  
        this.name = name;  
    }  
  
    public Student(String namee) {  
        super();  
        this.name = name;  
    }  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public byte[] getPic() {  
        return pic;  
    }  
  
    public void setPic(byte[] pic) {  
        this.pic = pic;  
    }  
  
    public String getRemark() {  
        return remark;  
    }  
  
    public void setRemark(String remark) {  
        this.remark = remark;  
    }  
  
    @Override  
    public String toString() {  
        return "Student [id=" + id + ", name=" + name + ", remark=" + remark + "]";  
    }  
  
}  