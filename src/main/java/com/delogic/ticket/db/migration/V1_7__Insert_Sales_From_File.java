package com.delogic.ticket.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_7__Insert_Sales_From_File extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();

        String filePath = "data/sales.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\t");

                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO sales (sale_id, listing_id, seller_id, buyer_id, event_id, date_id, quantity_sold, price_paid, commission_amount, sale_timestamp) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                    statement.setInt(1, Integer.parseInt(fields[0])); // sale_id
                    statement.setInt(2, Integer.parseInt(fields[1])); // listing_id
                    statement.setInt(3, Integer.parseInt(fields[2])); // seller_id
                    statement.setInt(4, Integer.parseInt(fields[3])); // buyer_id
                    statement.setInt(5, Integer.parseInt(fields[4])); // event_id
                    statement.setInt(6, Integer.parseInt(fields[5])); // date_id
                    statement.setInt(7, Integer.parseInt(fields[6])); // quantity_sold
                    statement.setBigDecimal(8, new java.math.BigDecimal(fields[7])); // price_paid
                    statement.setBigDecimal(9, new java.math.BigDecimal(fields[8])); // commission_amount
                    statement.setTimestamp(10, java.sql.Timestamp.valueOf(fields[9])); // sale_timestamp

                    statement.executeUpdate();
                }
            }
        }
    }
}
