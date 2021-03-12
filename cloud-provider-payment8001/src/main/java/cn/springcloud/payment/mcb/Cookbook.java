package cn.springcloud.payment.mcb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cookbook {
    public static Connection connect() throws Exception {
        String url = "jdbc:mysql//111.230.137.39/cookbook";
        String userName = "root";
        String password = "devops";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection(url, userName, password);
    }
    public static String getErrorMessage(Exception e) {
        StringBuffer s = new StringBuffer ();
        if (e instanceof SQLException) {
            // print general message, plus any database-specific message
            s.append ("Error message: " + e.getMessage () + "\n");
            s.append ("Error code: " + ((SQLException) e).getErrorCode () + "\n");
        }
        else {
            s.append (e + "\n");
        }
        return (s.toString ());
    }
    public static void printErrorMessage (Exception e) {
        System.err.println (Cookbook.getErrorMessage (e));
    }
}
