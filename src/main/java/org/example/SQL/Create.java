package org.example.SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create implements InCreate {

    public static void createTableUser(String tableName) throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "username VARCHAR(50) UNIQUE NOT NULL, "
                + "email VARCHAR(100) UNIQUE NOT NULL, "
                + "passwordHash VARCHAR(255) NOT NULL, "
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";


        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table '" + tableName + "' created successfully.");
        }
    }

    public static void createTableRecipes(String tableName) throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "userId INT NOT NULL,"
                + "FOREIGN KEY (userId) REFERENCES Users(id), "
                + "title VARCHAR(150) NOT NULL, "
                + "shortDescription VARCHAR(500), "
                + "instructions TEXT NOT NULL, "
                + "prepTimeMinutes INT, "
                + "isPublic BOOLEAN NOT NULL DEFAULT TRUE, "
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
                + ")";


        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table '" + tableName + "' created successfully.");
        }
    }

    public static void createTableIngredients(String tableName) throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "name  VARCHAR(100) UNIQUE NOT NULL,"
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";


        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table '" + tableName + "' created successfully.");
        }
    }

    public static void createTableRecipeIngredients(String tableName) throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "recipeId INT NOT NULL, "
                + "FOREIGN KEY (recipeId) REFERENCES Recipes(id), "
                + "ingredientId INT NOT NULL, "
                + "FOREIGN KEY (ingredientId) REFERENCES Ingredients(id), "
                + "quantity VARCHAR(100) NOT NULL, "
                + "position INT"
                + ")";


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

    @Override
    public void createRecipesTable() {
        try {
            Create.createTableRecipes("Recipes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createIngredientsTable() {
        try {
            Create.createTableIngredients("Ingredients");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createRecInTable() {
        try {
            Create.createTableRecipeIngredients("RecipeIngredients");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

