package project.dao;

import project.database.Database;
import project.exception.ClientNotFoundException;
import project.exception.DatabaseException;
import project.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    private static final String INSERT_CLIENT = "INSERT INTO client (name) VALUES (?)";
    private static final String GET_CLIENT = "SELECT * FROM client WHERE id = ?";
    private static final String UPDATE_CLIENT = "UPDATE Client SET name = ? WHERE id = ?";
    private static final String DELETE_CLIENT = "DELETE FROM Client WHERE id = ?";
    private static final String GET_ALL_CLIENTS = "SELECT * FROM Client";

    private static final String CLIENT_NOT_FOUND_MESSAGE = "Client with ID %s not found.";
    private static final String ERROR_ACCESSING_DB_MESSAGE = "Error accessing the database.";
    private ClientDao() {

    }
    public static long create(Client client) {
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_CLIENT, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new DatabaseException("Failed to retrieve generated keys after client creation.");
                }
            }
        } catch (Exception e) {
            throw new DatabaseException(ERROR_ACCESSING_DB_MESSAGE, e);
        }
    }

    public static Client getById(long id) {
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_CLIENT)
        ) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Client(
                            resultSet.getLong("id"),
                            resultSet.getString("name")
                    );
                } else {
                    throw new ClientNotFoundException(String.format(CLIENT_NOT_FOUND_MESSAGE, id));
                }
            }
        } catch (Exception e) {
            throw new DatabaseException(ERROR_ACCESSING_DB_MESSAGE, e);
        }
    }

    public static void update(Client client) {
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_CLIENT)
        ) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setLong(2, client.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new ClientNotFoundException(String.format(CLIENT_NOT_FOUND_MESSAGE, client.getId()));
            }
        } catch (Exception e) {
            throw new DatabaseException(ERROR_ACCESSING_DB_MESSAGE, e);
        }
    }

    public static void deleteById(long id) {
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_CLIENT)
        ) {
            preparedStatement.setLong(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new ClientNotFoundException(String.format(CLIENT_NOT_FOUND_MESSAGE, id));
            }
        } catch (Exception e) {
            throw new DatabaseException(ERROR_ACCESSING_DB_MESSAGE, e);
        }
    }

    public static List<Client> getAll() {
        List<Client> clientList = new ArrayList<>();

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_CLIENTS)
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    clientList.add(new Client(
                            resultSet.getLong("id"),
                            resultSet.getString("name")
                    ));
                }
            }
        } catch (Exception e) {
            throw new DatabaseException(ERROR_ACCESSING_DB_MESSAGE, e);
        }
        return clientList;
    }
}