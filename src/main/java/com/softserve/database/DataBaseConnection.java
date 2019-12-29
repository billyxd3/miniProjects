package com.softserve.database;

import com.softserve.constant.ErrorMessage;
import com.softserve.util.DataBasePropertiesParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataBaseConnection implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(DataBaseConnection.class);
    private final Map<Long, Connection> connections;
    private static volatile DataBaseConnection instance = null;


    private DataBaseConnection() {
        this.connections = new HashMap<>();
    }

    public Connection createConnection() {
        Connection connection = getAllConnections().get(Thread.currentThread().getId());
        if (connection == null) {
            LOG.info("Create connection to database");
            try {
                connection = DriverManager.getConnection(
                        DataBasePropertiesParser.getDataBaseProps("db_url"),
                        DataBasePropertiesParser.getDataBaseProps("db_login"),
                        DataBasePropertiesParser.getDataBaseProps("db_password"));
            } catch (SQLException e) {
                throw new RuntimeException(ErrorMessage.FAIL_TO_CREATE_CONNECTION.getErrorMessage(), e);
            }
            addConnection(connection);
        }
        return connection;
    }

    private Map<Long, Connection> getAllConnections() {
        return this.connections;
    }

    private void addConnection(Connection connection) {
        getAllConnections().put(Thread.currentThread().getId(), connection);
    }

    public static DataBaseConnection getInstance() {
        if (instance == null) {
            synchronized (DataBaseConnection.class) {
                if (instance == null) {
                    instance = new DataBaseConnection();
                }
            }
        }
        return instance;
    }

    @Override
    public void close() throws SQLException {
//        LOG.info("Closing connection to database");
//        connection.close();
    }

    public static void closeAllConnections() {
        if (instance != null) {
            for (Long key : instance.getAllConnections().keySet()) {
                if (instance.getAllConnections().get(key) != null) {
                    try {
                        instance.getAllConnections().get(key).close();
                    } catch (SQLException e) {
                        throw new RuntimeException(ErrorMessage.FAIL_TO_CLOSE_CONNECTION.getErrorMessage(), e);
                    }
                    instance.getAllConnections().put(key, null);
                }
            }
        }
    }
}