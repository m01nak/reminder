package com.moinak.reminder.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class DatabasePropertyReaderTest {
    @Test
    public void getDatabasePropertyTest() {
        String expectedDbHost = "192.168.1.12";
        String expectedDbPort = "61901";
        String expectedDbName = "reminder_db";
        String incorrectDbType = "mongodb";
        String defaultDbAbsentProperty = "default";

        String actualDbHost = DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.host");
        String actualDbPort = DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.port");
        String actualDbName = DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.name");
        String actualDbType = DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.type");
        String actualDbAbsentProperty = DatabasePropertyReader.INSTANCE.getDatabaseProperty("db.absentproperty", "default");

        assertEquals(expectedDbHost, actualDbHost);
        assertEquals(expectedDbPort, actualDbPort);
        assertEquals(expectedDbName, actualDbName);
        assertNotEquals(incorrectDbType, actualDbType);
        assertEquals(defaultDbAbsentProperty, actualDbAbsentProperty);
        
    }
}
