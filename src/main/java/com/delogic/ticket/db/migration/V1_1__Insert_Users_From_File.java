package com.delogic.ticket.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_1__Insert_Users_From_File extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();
        int lineNumber = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/users.txt")))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");

                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO users (user_id, username, first_name, last_name, address, prefered_flags) " +
                                "VALUES (?, ?, ?, ?, JSON_OBJECT('city', ?, 'state', ?), " +
                                "JSON_OBJECT('sports', ?, 'theatre', ?, 'concerts', ?, 'jazz', ?, 'classical', ?, 'opera', ?, 'rock', ?, 'vegas', ?, 'broadway', ?, 'musicals', ?))")) {

                    statement.setLong(1, Long.parseLong(fields[0])); // user_id
                    statement.setString(2, fields[1]); // username
                    statement.setString(3, fields[2]); // first_name
                    statement.setString(4, fields[3]); // last_name
                    statement.setString(5, fields[4]); // city
                    statement.setString(6, fields[5]); // state
                    statement.setBoolean(7, "true".equalsIgnoreCase(fields[8])); // sports
                    statement.setBoolean(8, "true".equalsIgnoreCase(fields[9])); // theatre
                    statement.setBoolean(9, "true".equalsIgnoreCase(fields[10])); // concerts
                    statement.setBoolean(10, "true".equalsIgnoreCase(fields[11])); // jazz
                    statement.setBoolean(11, "true".equalsIgnoreCase(fields[12])); // classical
                    statement.setBoolean(12, "true".equalsIgnoreCase(fields[13])); // opera
                    statement.setBoolean(13, "true".equalsIgnoreCase(fields[14])); // rock
                    statement.setBoolean(14, "true".equalsIgnoreCase(fields[15])); // vegas
                    statement.setBoolean(15, "true".equalsIgnoreCase(fields[16])); // broadway
                    statement.setBoolean(16, "true".equalsIgnoreCase(fields[17])); // musicals

                    statement.executeUpdate();
                } catch (Exception e) {
                }
            }
        }
    }
}