package com.metlife.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MysqlHelper {

    public static Connection conn;

    public static Connection getConnection() throws SQLException {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("db");
        String userName=resourceBundle.getString("username");
        String password=resourceBundle.getString("password");
        String url=resourceBundle.getString("url");
       return  DriverManager.getConnection(url,userName,password);

    }
}
