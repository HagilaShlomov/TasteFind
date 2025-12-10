package org.example.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

    public static void insertTableUser(String username, String email, String passwordHash) throws SQLException {

        String sql = "INSERT INTO Users (username, email, passwordHash) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, passwordHash);

            ps.executeUpdate();
            System.out.println("User inserted successfully.");
        }
    }

    public static void insertTableRecipes(int userId, String title, String shortDescription,
                                          String instructions, Integer prepTimeMinutes, boolean isPublic)
            throws SQLException {

        String sql = "INSERT INTO Recipes (userId, title, shortDescription, instructions, prepTimeMinutes, isPublic) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, title);
            ps.setString(3, shortDescription);
            ps.setString(4, instructions);

            if (prepTimeMinutes != null) {
                ps.setInt(5, prepTimeMinutes);
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }

            ps.setBoolean(6, isPublic);

            ps.executeUpdate();
            System.out.println("Recipe inserted successfully.");
        }
    }

    public static void insertTableIngredients(String name) throws SQLException {

        String sql = "INSERT INTO Ingredients (name) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.executeUpdate();

            System.out.println("Ingredient inserted successfully.");
        }
    }

    public static void insertTableRecipeIngredients(int recipeId, int ingredientId,
                                                    String quantity, Integer position)
            throws SQLException {

        String sql = "INSERT INTO RecipeIngredients (recipeId, ingredientId, quantity, position) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, recipeId);
            ps.setInt(2, ingredientId);
            ps.setString(3, quantity);

            if (position != null) {
                ps.setInt(4, position);
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();
            System.out.println("RecipeIngredient inserted successfully.");
        }
    }
}
