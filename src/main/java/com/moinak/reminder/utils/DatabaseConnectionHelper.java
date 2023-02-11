package com.moinak.reminder.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionHelper {
    
    public static final DatabaseConnectionHelper INSTANCE = new DatabaseConnectionHelper();

    private DatabaseConnectionHelper () {}

    public Connection getConnection() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/default_db","moinak","9N&t*26&");  
        } catch (Exception dbException) {
            System.out.println("Encountered exception while creating connection to database! Find more below:");
            System.out.println(dbException);
        }
        
        return connection;
    }

}
