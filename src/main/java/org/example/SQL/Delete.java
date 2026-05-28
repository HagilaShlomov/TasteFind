package org.example.SQL;
import org.hibernate.annotations.processing.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@Service
public class Delete {

    private static DataSource dataSource;
    @Autowired
    public Delete(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void dropTable(String tableName) throws SQLException {
        if (!tableName.matches("[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException("Invalid table name");
        }

        String sql = "DROP TABLE IF EXISTS " + tableName;

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table '" + tableName + "' dropped successfully.");
        }
    }


    public static void delTableUsers(){
        try {
            Delete.dropTable("Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delTableRecipes(){
        try {
            Delete.dropTable("Recipes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delTableIngredients(){
        try {
            Delete.dropTable("Ingredients");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delTableRecipeIngredients(){
        try {
            Delete.dropTable("RecipeIngredients");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
