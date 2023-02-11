package com.moinak.reminder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.moinak.reminder.utils.DatabaseConnectionHelper;

public class App {
    public static void main(String[] args) {
        Connection connection = DatabaseConnectionHelper.INSTANCE.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String currentKey = null;
        String currentValue = null;
        try {
            ps = connection.prepareStatement("select * from dummy");
            rs = ps.executeQuery();
            ps.close();
            connection.close();
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
