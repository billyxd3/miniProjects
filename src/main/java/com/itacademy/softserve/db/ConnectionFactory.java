package com.itacademy.softserve.db;

import com.itacademy.softserve.entity.SqlQueries;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectionFactory {
    private final String URL = "jdbc:mysql://localhost:3306/to_do_list?autoReconnect=true&useSSL=false";
    private final String USER_NAME = "arch";
    private final String PASSWORD = "arch006";

    private static volatile ConnectionFactory connectionFactory;
    private final Map<Long, Connection> connections;

    private ConnectionFactory() {
        this.connections = new HashMap<>();
    }

    public static ConnectionFactory getConnectionFactory() {
        if (connectionFactory == null) {
            synchronized (ConnectionFactory.class) {
                connectionFactory = new ConnectionFactory();
            }
        }
        return connectionFactory;
    }

    private void addConnection(Connection connection) {
        connections.put(Thread.currentThread().getId(), connection);
    }

    private Map<Long, Connection> getAllConnections() {
        return this.connections;
    }

    public Connection getConnection() {
        Connection connection = connections.get(Thread.currentThread().getId());
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            addConnection(connection);
        }
        return connection;
    }

    public void beginTransaction() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void commitTransaction() {
        try {
            getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollbackTransaction() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeAllConnection() {
        if (connectionFactory != null) {
            for (Long key : connectionFactory.getAllConnections().keySet()) {
                if (connectionFactory.getAllConnections().get(key) != null) {
                    try {
                        connectionFactory.getAllConnections().get(key).close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    connectionFactory.getAllConnections().put(key, null);
                }
            }
        }
    }
}
