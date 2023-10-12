package com.metlife.dao;

import com.metlife.helpers.MysqlHelper;
import com.metlife.models.User;

import java.sql.*;
import java.util.*;

public class AppDao {

        private static Connection conn;
        private static Statement statement;
        private static PreparedStatement preparedStatement;

        private static ResourceBundle resourceBundle;
        private static ResultSet resultSet;




        public static List<User> getUsers() throws SQLException {
            conn= MysqlHelper.getConnection();
            resourceBundle=ResourceBundle.getBundle("db");
            String query = resourceBundle.getString("query");
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(resultSet.getString(1).toString(),
                        resultSet.getString(2).toString()));
            }
         System.out.println(users.size());
         return users;
        }
    public static User getUser(String username) throws SQLException {
        conn= MysqlHelper.getConnection();
        resourceBundle=ResourceBundle.getBundle("db");
        String query = resourceBundle.getString("specificuserquery");
      preparedStatement=conn.prepareStatement(query);
      preparedStatement.setString(1,username);
        resultSet = preparedStatement.executeQuery();
       resultSet.next();
       return new User(resultSet.getString(1).toString(),resultSet.getString(2).toString());


    }


    public static List<User> generateUsers(){

        List<User> users=new ArrayList<User>();

        for(int i=0;i<5;i++){
            users.add(new User("user"+i,"pass"+new Random().nextInt(100000)));
        }

        return users;

    }


}
