package cn.springcloud.payment.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:mysql//111.230.137.39/cookbook";
        String userName = "root";
        String password = "devops";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("connected...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (conn !=null) {
            try {
                conn.close();
                System.out.println("Disconnected...");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
