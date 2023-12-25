package java_mysql;

import java.sql.*;

public class Request {

    public static void insertUser(String password, String passwordHashed, String email, int role_id) {
        try {
            Connection connection = javaMysqlConnection.getConnection();
            String query = "INSERT INTO users (password, passwordHashed, email, role_id) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, passwordHashed);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, role_id);
            preparedStatement.executeUpdate();
            System.out.println("Utilisateur inséré avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion de l'utilisateur : " + e.getMessage());
        }
    }

    public static void displayRoles() {
        try {
            Connection connection = javaMysqlConnection.getConnection();
            String query = "SELECT * FROM roles";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + " "+ resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des rôles : " + e.getMessage());
        }
    }

    public static void displayUsers() {
        try {
            Connection connection = javaMysqlConnection.getConnection();
            String query = "SELECT users.id, users.passwordHashed, users.email, roles.name FROM users INNER JOIN roles ON users.role_id = roles.id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", PasswordHashed: "
                        + resultSet.getString("passwordHashed")
                        + ", Email: " + resultSet.getString("email") + ", Role: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des utilisateurs : " + e.getMessage());
        }
    }

    public static void displayRoleById(int roleId) {
        try {
            Connection connection = javaMysqlConnection.getConnection();
            String query = "SELECT * FROM roles WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, roleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Role: " + resultSet.getString("name"));
            } else {
                System.out.println("Aucun rôle trouvé avec l'ID : " + roleId);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage du rôle : " + e.getMessage());
        }
    }
}