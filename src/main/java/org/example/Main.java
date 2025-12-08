package org.example;

import org.example.SQL.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.example.SQL.Create;
import org.example.SQL.InCreate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("✅ Connected successfully to MySQL!");
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }

        Create.createTableUser("Users");
        Create.createTableRecipes("Recipes");
        Create.createTableIngredients("Ingredients");
        Create.createTableRecipeIngredients("RecipeIngredients");


    }
}