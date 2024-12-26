package com.delogic.ticket.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_1__Insert_Users_From_File extends BaseJavaMigration {

    private static final String TRUE = "true";

    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data/users.txt")))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\|\\||\\|$", "|null|");
                line = line.replaceAll("\\|\\||\\|$", "|null|");
                String[] fields = new String[18];
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = "null";
                }
                String[] firstFields = line.split("\\|");
                for (int i = 0; i < firstFields.length - 1; i++) {
                    fields[i] = firstFields[i];
                }

                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO users (user_id, username, first_name, last_name, address, prefered_flags) " +
                                "VALUES (?, ?, ?, ?, JSON_OBJECT('city', ?, 'state', ?, 'email', ?, 'phone', ?), " +
                                "JSON_OBJECT('sports', ?, 'theatre', ?, 'concerts', ?, 'jazz', ?, 'classical', ?, 'opera', ?, 'rock', ?, 'vegas', ?, 'broadway', ?, 'musicals', ?))")) {

                    statement.setLong(1, Long.parseLong(fields[0])); // user_id
                    statement.setString(2, fields[1]); // username
                    statement.setString(3, fields[2]); // first_name
                    statement.setString(4, fields[3]); // last_name
                    statement.setString(5, fields[4]); // city
                    statement.setString(6, fields[5]); // state
                    statement.setString(7, fields[6]); //email
                    statement.setString(8, fields[7]); //phone
                    statement.setBoolean(9, TRUE.equalsIgnoreCase(fields[8])); // sports
                    statement.setBoolean(10, TRUE.equalsIgnoreCase(fields[9])); // theatre
                    statement.setBoolean(11, TRUE.equalsIgnoreCase(fields[10])); // concerts
                    statement.setBoolean(12, TRUE.equalsIgnoreCase(fields[11])); // jazz
                    statement.setBoolean(13, TRUE.equalsIgnoreCase(fields[12])); // classical
                    statement.setBoolean(14, TRUE.equalsIgnoreCase(fields[13])); // opera
                    statement.setBoolean(15, TRUE.equalsIgnoreCase(fields[14])); // rock
                    statement.setBoolean(16, TRUE.equalsIgnoreCase(fields[15])); // vegas
                    statement.setBoolean(17, TRUE.equalsIgnoreCase(fields[16])); // broadway
                    statement.setBoolean(18, TRUE.equalsIgnoreCase(fields[17])); // musicals

                    statement.executeUpdate();
                    connection.commit();
                } catch (Exception e) {
                    System.out.println("Erro ao inserir a linha");
                    System.out.println(line);
                }
            }
        }
    }
}