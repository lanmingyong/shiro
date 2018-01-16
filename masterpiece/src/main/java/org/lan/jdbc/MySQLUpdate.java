package org.lan.jdbc;
import org.lan.utils.RandomValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class MySQLUpdate {
    static Connection con = MySQLConnections.getConnection();
    static PreparedStatement stmt = null;
    public static int executeInsert() throws SQLException {
        Map<String,String> obj=null;
        int i = 0;
        //设置批量处理的数量             
        int batchSize = 10000;
        stmt = con.prepareStatement("insert into mysqltest (`name`,`sex`,`road`,`tel`,`email`) "
                + "values (?,?,?,?,?)");
        // 关闭事务自动提交 ,这一行必须加上
        con.setAutoCommit(false);
        for (int j = 0; j < 500005; j++){
            ++i;
            obj=RandomValue.getData();
            stmt.setString(1, obj.get("name"));
            stmt.setString(2, obj.get("sex"));
            stmt.setString(3, obj.get("road"));
            stmt.setString(4, obj.get("tel"));
            stmt.setString(5, obj.get("email"));
            stmt.addBatch();
            if ( i % batchSize == 0 ) {
                stmt.executeBatch();
                con.commit();
            }
        }

        return i;
    }

    public static  void executeInsert2() throws SQLException {
        Map<String,String> obj=null;
        // 关闭事务自动提交 ,这一行必须加上  
        con.setAutoCommit(false);
        stmt = con.prepareStatement("insert into mysqltest1 (`name`,`sex`,`road`,`tel`,`email`) "
                + "values (?,?,?,?,?)");
        for (int j = 0; j < 500002; j++){
            obj=RandomValue.getData();
            stmt.setString(1, obj.get("name"));
            stmt.setString(2, obj.get("sex"));
            stmt.setString(3, obj.get("road"));
            stmt.setString(4, obj.get("tel"));
            stmt.setString(5, obj.get("email"));
            stmt.addBatch();
        }
        stmt.executeBatch();
        con.commit();
        stmt.close();   
        con.close();
    }

}