package com.softserve.util;

import com.softserve.constant.ErrorMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataBasePropertiesParser {

    public static String getDataBaseProps(String dbProperty) {
        Properties prop = new Properties();
        try (InputStream input = DataBasePropertiesParser.class.getClassLoader()
                .getResourceAsStream("db_connection.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            throw new RuntimeException(ErrorMessage.FAIL_TO_READ_DATABASE_PROPERTIES.getErrorMessage(), ex);
        }
        return prop.getProperty(dbProperty);
    }
}