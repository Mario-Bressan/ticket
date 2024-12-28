package com.delogic.ticket.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_5__Insert_Events_From_File extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();

        String filePath = "data/events.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");

                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO events (event_id, venue_id, category_id, date_id, event_name, event_start_time) " +
                                "VALUES (?, ?, ?, ?, ?, ?)")) {

                    statement.setInt(1, Integer.parseInt(fields[0])); // event_id
                    statement.setInt(2, Integer.parseInt(fields[1])); // venue_id
                    statement.setInt(3, Integer.parseInt(fields[2])); // category_id
                    statement.setInt(4, Integer.parseInt(fields[3])); // date_id
                    statement.setString(5, fields[4]); // event_name
                    statement.setTimestamp(6, java.sql.Timestamp.valueOf(fields[5])); // event_start_time

                    statement.executeUpdate();
                }
            }
        }
    }
}