package com.dev.inspec.config;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class TesteConfig {

    private static final String URL = "jdbc:mysql://your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public void instantiateTestDatabase() {
        // Your existing code remains unchanged...
    }

    private void executeSql(Connection connection, String sql) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }
}
