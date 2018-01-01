package org.lan.shiro.service;

import org.apache.shiro.authz.annotation.RequiresRoles;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShiroService {

    @RequiresRoles(value = {"admin"})
    public void testMethod(){
        Date date=new Date();
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateString=formatter.format(date);
        System.out.println("testMethod time:"+dateString);
    }
}
