package com.itacademy.softserve.dao;

import java.sql.*;

public class ConnectionFactory {
    private Connection connection;
    public static final String URL = "jdbc:mysql://localhost:3306/to_do_list?autoReconnect=true&useSSL=false";
    public static final String USER_NAME = "arch";
    public static final String PASSWORD = "arch006";

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            return connection;
        } catch (SQLException e) {

        }
        return null;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {

        }
    }
}
