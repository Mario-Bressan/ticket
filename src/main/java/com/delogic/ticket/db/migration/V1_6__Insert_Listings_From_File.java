package com.delogic.ticket.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_6__Insert_Listings_From_File extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();

        String filePath = "data/listings.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");

                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO listings (listing_id, seller_id, event_id, date_id, number_of_tickets, price_per_ticket, total_price, listing_timestamp) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

                    statement.setInt(1, Integer.parseInt(fields[0])); // listing_id
                    statement.setInt(2, Integer.parseInt(fields[1])); // seller_id
                    statement.setInt(3, Integer.parseInt(fields[2])); // event_id
                    statement.setInt(4, Integer.parseInt(fields[3])); // date_id
                    statement.setInt(5, Integer.parseInt(fields[4])); // number_of_tickets
                    statement.setBigDecimal(6, new java.math.BigDecimal(fields[5])); // price_per_ticket
                    statement.setBigDecimal(7, new java.math.BigDecimal(fields[6])); // total_price
                    statement.setTimestamp(8, java.sql.Timestamp.valueOf(fields[7])); // listing_timestamp

                    statement.executeUpdate();
                }
            }
        }
    }
}
