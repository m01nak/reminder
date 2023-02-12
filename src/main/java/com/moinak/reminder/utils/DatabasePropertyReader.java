package com.moinak.reminder.utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabasePropertyReader {

    private Properties databaseProperties;
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabasePropertyReader.class);
    public static final DatabasePropertyReader INSTANCE = new DatabasePropertyReader();

    private DatabasePropertyReader() {
        LOGGER.info("Initializing database properties.");
        try {
            databaseProperties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream propertyInputStream = loader.getResourceAsStream("database.properties");
            databaseProperties.load(propertyInputStream);
        } catch (Exception e) {
            LOGGER.error("Error while loading database properties!");
            LOGGER.error(e.toString());
        }
    };

    public String getDatabaseProperty(String propertyKey) {
        if (this.databaseProperties != null) {
            return this.databaseProperties.getProperty(propertyKey);
        } else {
            return null;
        }
    }

    public String getDatabaseProperty(String propertyKey, String defaultValue) {
        if (this.databaseProperties != null) {
            return this.databaseProperties.getProperty(propertyKey, defaultValue);
        } else {
            return null;
        }
    }

}
