package org.example.SQL;

import org.hibernate.annotations.processing.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@Service
public class Create implements InCreate {
    private static DataSource dataSource;

    @Autowired
    public Create(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public static void createTableUser() throws SQLException {

        String sql = """
        CREATE TABLE IF NOT EXISTS user (
            id INT PRIMARY KEY AUTO_INCREMENT,
            username VARCHAR(50) UNIQUE NOT NULL,
            email VARCHAR(100) UNIQUE NOT NULL,
            passwordHash VARCHAR(255) NOT NULL,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        );
        """;


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table 'User' created successfully.");
        }
    }

    public static void createTableRecipes() throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS recipes(
                id INT PRIMARY KEY AUTO_INCREMENT, 
                userId INT NOT NULL,
                FOREIGN KEY (userId) REFERENCES Users(id), 
                title VARCHAR(150) NOT NULL, 
                shortDescription VARCHAR(500), 
                instructions TEXT NOT NULL, 
                prepTimeMinutes INT, 
                isPublic BOOLEAN NOT NULL DEFAULT TRUE, 
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
                );
            """;


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table 'Recipes' created successfully.");
        }
    }

    public static void createTableIngredients() throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS ingredients (
                id INT PRIMARY KEY AUTO_INCREMENT, 
                name  VARCHAR(100) UNIQUE NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                );
                """;


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table 'Ingredients' created successfully.");
        }
    }

    public static void createTableRecipeIngredients() throws SQLException {

        String sql = """ 
                CREATE TABLE IF NOT EXISTS recipeIngredients (
                id INT PRIMARY KEY AUTO_INCREMENT, 
                recipeId INT NOT NULL, 
                FOREIGN KEY (recipeId) REFERENCES Recipes(id), 
                ingredientId INT NOT NULL, 
                FOREIGN KEY (ingredientId) REFERENCES Ingredients(id), 
                quantity VARCHAR(100) NOT NULL, 
                position INT
                );
                """;


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table 'RecipeIngredients' created successfully.");
        }
    }



    @Override
    public void createUserTable() {
        try {
            Create.createTableUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createRecipesTable() {
        try {
            Create.createTableRecipes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createIngredientsTable() {
        try {
            Create.createTableIngredients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createRecInTable() {
        try {
            Create.createTableRecipeIngredients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

