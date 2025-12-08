package org.example.SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create implements InCreate {

    public static void createTableUser(String tableName) throws SQLException {
        // בדיקה לשם תקין בלבד
        if (!tableName.matches("[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException("Invalid table name");
        }

        // בניית שאילתה
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "username VARCHAR(50) UNIQUE NOT NULL, "
                + "email VARCHAR(100) UNIQUE NOT NULL, "
                + "passwordHash VARCHAR(255) NOT NULL, "
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";

        // שימוש במחלקת החיבור שלך
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table '" + tableName + "' created successfully.");
        }
    }

    public static void createTableRecipes(String tableName) throws SQLException {
        // בדיקה לשם תקין בלבד
        if (!tableName.matches("[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException("Invalid table name");
        }

        // בניית שאילתה
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "userId BIGINT NOT NULL,"
                + "FOREIGN KEY (userId) REFERENCES Users(id), "
                + "title VARCHAR(150) NOT NULL, "
                + "shortDescription VARCHAR(500), "
                + "instructions TEXT NOT NULL, "
                + "prepTimeMinutes INT, "
                + "isPublic BOOLEAN NOT NULL DEFAULT TRUE, "
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
                + ")";

        // שימוש במחלקת החיבור שלך
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table '" + tableName + "' created successfully.");
        }
    }



    @Override
    public void createUserTable() {
        try {
            Create.createTableUser("Users");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

