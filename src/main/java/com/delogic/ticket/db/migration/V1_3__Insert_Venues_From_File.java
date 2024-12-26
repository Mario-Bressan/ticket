package com.delogic.ticket.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_3__Insert_Venues_From_File extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();

        String filePath = "data/venues.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");

                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO venues (venue_id, venue_name, city, state, seating_capacity) " +
                                "VALUES (?, ?, ?, ?, ?)")) {

                    statement.setLong(1, Long.parseLong(fields[0])); // venue_id
                    statement.setString(2, fields[1]); // venue_name
                    statement.setString(3, fields[2]); // city
                    statement.setString(4, fields[3]); // state
                    statement.setInt(5, Integer.parseInt(fields[4])); // seating_capacity

                    statement.executeUpdate();
                }
            }
        }
    }
}
