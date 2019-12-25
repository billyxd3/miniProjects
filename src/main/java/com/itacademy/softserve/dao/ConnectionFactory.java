package com.itacademy.softserve.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ConnectionFactory {
    private Logger logger = LogManager.getLogger("HigherWarn");
    private Connection connection;
    public static final String URL = "jdbc:mysql://localhost:3306/to_do_list?autoReconnect=true&useSSL=false";
    public static final String USER_NAME = "arch";
    public static final String PASSWORD = "arch006";

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            logger.debug("Connected successfully");
            return connection;
        } catch (SQLException e) {
            logger.debug("Fail to connect");
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        try {
            connection.close();
            logger.debug("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
