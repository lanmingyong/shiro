package org.lan.jdbc;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        String osName = System.getProperty("os.name");
        String user = System.getProperty("user.name");
        System.out.println("当前操作系统是:" + osName);
        System.out.println("当前用户是:" + user);
        long begin1 = System.currentTimeMillis();
        MySQLUpdate.executeInsert();
        long end1 = System.currentTimeMillis();
        System.out.println("程序运行时间为：" + (end1 - begin1) / 1000.0 + "秒");

        long begin2 = System.currentTimeMillis();
        MySQLUpdate.executeInsert2();
        long end2 = System.currentTimeMillis();
        System.out.println("程序运行时间为：" + (end2 - begin2) / 1000.0 + "秒");
    }
}
