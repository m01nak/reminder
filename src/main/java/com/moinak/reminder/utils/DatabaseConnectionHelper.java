package com.moinak.reminder.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionHelper {
    
    public static final DatabaseConnectionHelper INSTANCE = new DatabaseConnectionHelper();

    private DatabaseConnectionHelper () {}

    public Connection getConnection() {
        Connection connection = null;
        
        try {
            String dbUrl = "jdbc:"
                            +
                            DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.type") + "://"
                            +
                            DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.host") + ":"
                            +
                            DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.port") + "/"
                            +
                            DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.name");
            String dbUser = DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.user");
            String dbPass = DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.pass");

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);  
        } catch (Exception dbException) {
            System.out.println("Encountered exception while creating connection to database! Find more below:");
            System.out.println(dbException);
        }
        
        return connection;
    }

}
