package com.itacademy.softserve.util;

import sun.tools.java.Type;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtils {
    public int update(Connection connection, String query, Object... args) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setArgsToStatement(preparedStatement, args);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private void setArgsToStatement(PreparedStatement preparedStatement, Object... args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    preparedStatement.setNull(i + 1, Type.NULL);
                } else if (String.class.equals(args[i].getClass())) {
                    preparedStatement.setString(i + 1, (String) args[i]);
                } else if (Long.class.equals(args[i].getClass())) {
                    preparedStatement.setLong(i + 1, (Long) args[i]);
                } else if (Integer.class.equals(args[i].getClass())) {
                    preparedStatement.setInt(i + 1, (Integer) args[i]);
                } else if (Date.class.equals(args[i].getClass())) {
                    preparedStatement.setDate(i + 1, (Date) args[i]);
                } else {
                    //throw custom error
                }
            }
        } catch (SQLException e) {

        }
    }
}


