package com.itacademy.softserve.util;

import com.itacademy.softserve.builder.InstanceBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudUtils {

    public static <TEntity> TEntity getEntity(Connection connection, String query, InstanceBuilder<TEntity> mapper, Object... args) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setArgsToStatement(preparedStatement, args);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapper.createInstance(resultSet);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static <TEntity> List<TEntity> getEntityList(Connection connection, String query, InstanceBuilder<TEntity> mapper, Object... args) {
        List<TEntity> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setArgsToStatement(preparedStatement, args);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    entityList.add(mapper.createInstance(resultSet));
                }
                return entityList;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static <TEntity> List<TEntity> getAll(Connection connection, String query, InstanceBuilder<TEntity> mapper) {
        List<TEntity> all = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    all.add(mapper.createInstance(resultSet));
                }
                return all;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static int update(Connection connection, String query, Object... args) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setArgsToStatement(preparedStatement, args);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private static void setArgsToStatement(PreparedStatement preparedStatement, Object... args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    preparedStatement.setNull(i + 1, Types.NULL);
                } else if (String.class.equals(args[i].getClass())) {
                    preparedStatement.setString(i + 1, (String) args[i]);
                } else if (Long.class.equals(args[i].getClass())) {
                    preparedStatement.setLong(i + 1, (Long) args[i]);
                } else if (Integer.class.equals(args[i].getClass())) {
                    preparedStatement.setInt(i + 1, (Integer) args[i]);
                } else if (Date.class.equals(args[i].getClass())) {
                    preparedStatement.setDate(i + 1, (Date) args[i]);
                } else {
                    //throw custom exception
                }
            }
        } catch (SQLException e) {

        }
    }
}


