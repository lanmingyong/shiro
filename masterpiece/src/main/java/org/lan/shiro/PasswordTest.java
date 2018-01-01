package org.lan.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class PasswordTest {
    @Test
    public void  test() {
        String algorithmName="md5";
        Object source="123456";
        Object salt="admin";
        int hashIterations=1024;
        Object result=new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
        salt="user";
        result=new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
    }

    @Test
    public void  test2() {
        String algorithmName="sha1";
        Object source="123456";
        Object salt="admin";
        int hashIterations=1024;
        Object result=new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
        salt="user";
        result=new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
    }

}
