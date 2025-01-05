package com.delogic.ticket.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_4__Insert_Dates_2008_From_File extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();

        String filePath = "data/dates_2008.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");

                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO dates (date_id, calendar_date, day, week, month, quarter, year, holiday_flag) " +
                                "VALUES (?, str_to_date(?, '%Y-%m-%d'), ?, ?, ?, ?, ?, ?)")) {

                    statement.setInt(1, Integer.parseInt(fields[0]));
                    statement.setDate(2, java.sql.Date.valueOf(fields[1]));
                    statement.setString(3, fields[2]);
                    statement.setInt(4, Integer.parseInt(fields[3]));
                    statement.setString(5, fields[4]);
                    statement.setInt(6, Integer.parseInt(fields[5]));
                    statement.setInt(7, Integer.parseInt(fields[6]));
                    statement.setBoolean(8, Boolean.parseBoolean(fields[7]));

                    statement.executeUpdate();
                }
            }
        }
    }
}
