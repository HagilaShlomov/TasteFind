package org.example;

import org.example.Entity.User;
import org.example.SQL.DatabaseConnection;
import org.example.Services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Main.class, args);

//        try (Connection conn = DatabaseConnection.getConnection()) {
//            System.out.println("✅ Connected successfully to MySQL!");
//        } catch (SQLException e) {
//            System.out.println("❌ Connection failed: " + e.getMessage());
//        }

    }
}