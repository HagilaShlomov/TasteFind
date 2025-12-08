package org.example.SQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    public static void dropTable(String tableName) throws SQLException {
        // בדיקה לשם תקין בלבד
        if (!tableName.matches("[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException("Invalid table name");
        }

        // בניית שאילתה למחיקת הטבלה
        String sql = "DROP TABLE IF EXISTS " + tableName;

        // שימוש במחלקת החיבור שלך
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table '" + tableName + "' dropped successfully.");
        }
    }


    public static void delTableUsers(){
        try {
            Delete.dropTable("Users");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delTableRecipes(){
        try {
            Delete.dropTable("Recipes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delTableIngredients(){
        try {
            Delete.dropTable("Ingredients");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delTableRecipeIngredients(){
        try {
            Delete.dropTable("RecipeIngredients");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
