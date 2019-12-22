package com.softserve.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private  Logger log = LogManager.getLogger(ConnectionManager.class);
    private  final String url = "jdbc:mysql://127.0.0.1:3306/service_auto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private  final String user = "root";
    private  final String password = "ass123ass";

    private Connection connection = null;

    private ConnectionManager() {
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
             log.error(e.getMessage());
            }
        }
        return connection;
    }
}
