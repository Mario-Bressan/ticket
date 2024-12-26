package com.delogic.ticket.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_2__Insert_Categories_From_File extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();

        // Caminho do arquivo dentro do classpath
        String filePath = "data/categories.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");

                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO categories (category_id, category_group, category_name, category_description) " +
                                "VALUES (?, ?, ?, ?)")) {

                    statement.setLong(1, Long.parseLong(fields[0])); // category_id
                    statement.setString(2, fields[1]); // category_group
                    statement.setString(3, fields[2]); // category_name
                    statement.setString(4, fields[3]); // category_description

                    statement.executeUpdate();
                }
            }
        }
    }
}
