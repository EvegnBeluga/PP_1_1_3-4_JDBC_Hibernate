package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static void main(String[] args) {
         String URL = "jdbc:mysql://localhost:3306/mysql";
         String USERNAME = "root";
         String PASSWORD = "9949";
        Connection connection;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // System.out.println("соединение установлено");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // реализуйте настройку соеденения с БД
    }

    public static void getConnection() {
    }
}
