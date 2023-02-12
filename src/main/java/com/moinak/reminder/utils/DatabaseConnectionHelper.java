package com.moinak.reminder.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseConnectionHelper {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionHelper.class);

    public static final DatabaseConnectionHelper INSTANCE = new DatabaseConnectionHelper();

    private DatabaseConnectionHelper () {
        LOGGER.info("Creating instance of DatabaseConnectionHelper.");
    }

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

            LOGGER.debug("dbUrl: " + dbUrl);
            LOGGER.debug("dbUser: " + dbUser);
            LOGGER.debug("dbPass: " + dbPass);

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            LOGGER.debug("Database connection created successfully. Sending it where it is needed.");
        } catch (Exception dbException) {
            LOGGER.error("Encountered exception while creating connection to database! Find more below:");
            LOGGER.error(dbException.toString());
            LOGGER.error("Sending back null to caller");
        }

        return connection;
    }

}
