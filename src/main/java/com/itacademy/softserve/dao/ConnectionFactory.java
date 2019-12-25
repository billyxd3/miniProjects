package com.itacademy.softserve.dao;

import com.itacademy.softserve.dto.User;

import java.sql.*;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/to_do_list?autoReconnect=true&useSSL=false";
    public static final String USER_NAME = "arch";
    public static final String PASSWORD = "arch006";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Connected");
            return connection;
        } catch (SQLException e) {
            System.out.println("Failed");
        }
        return null;
    }
}
