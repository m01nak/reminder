package com.moinak.reminder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.moinak.reminder.utils.DatabaseUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Connection connection = DatabaseUtils.INSTANCE.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String currentKey = null;
        String currentValue = null;
        try {
            ps = connection.prepareStatement("select * from dummy");
            rs = ps.executeQuery();
            while(rs.next()) {
                currentKey = rs.getString("dummy_key");
                currentValue = rs.getString("dummy_val");

                System.out.println("Key: " + currentKey + " Value: " + currentValue);
            }
        } catch (Exception appException) {
            System.out.println("Error while running app! Find more below: ");
            System.out.println(appException);
        }
    }
}
