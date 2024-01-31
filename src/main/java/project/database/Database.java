package project.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class Database {
    private static Database instance;
    private String url;
    private String login;
    private String password;

    private Database() {
        loadDatabaseProperties();
    }

    private void loadDatabaseProperties() {
        try (FileInputStream fileInputStream = new FileInputStream("sql/database.properties")) {
            Properties prop = new Properties();
            prop.load(fileInputStream);

            url = prop.getProperty("url");
            login = prop.getProperty("login");
            password = prop.getProperty("password");

        } catch (IOException e) {
            throw new RuntimeException("Error loading database.properties", e);
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}