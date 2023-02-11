package com.moinak.reminder.utils;

import java.io.InputStream;
import java.util.Properties;

public class DatabasePropertyReader {
    
    private Properties databaseProperties;
    public static final DatabasePropertyReader INSTANCE = new DatabasePropertyReader();
    
    private DatabasePropertyReader() {
        try {
            databaseProperties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream propertyInputStream = loader.getResourceAsStream("database.properties");
            databaseProperties.load(propertyInputStream);
        } catch (Exception e) {
            System.out.println("Error while loading database properties!");
            System.out.println(e);
        }
    };

    public String getDatabaseProperty(String propertyKey) {
        if(this.databaseProperties != null) {
            return this.databaseProperties.getProperty(propertyKey);
        } else {
            return null;
        }
    }

    public String getDatabaseProperty(String propertyKey, String defaultValue) {
        if(this.databaseProperties != null) {
            return this.databaseProperties.getProperty(propertyKey, defaultValue);
        } else {
            return null;
        }
    }

}
