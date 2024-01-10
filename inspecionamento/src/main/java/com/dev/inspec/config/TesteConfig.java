package com.dev.inspec.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class TesteConfig {

    @SuppressWarnings("unused")
	private static final String URL = "jdbc:mysql://your_database_url";
    @SuppressWarnings("unused")
	private static final String USER = "your_username";
    @SuppressWarnings("unused")
	private static final String PASSWORD = "your_password";

    public void instantiateTestDatabase() {
    }

    @SuppressWarnings("unused")
	private void executeSql(Connection connection, String sql) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }
}
