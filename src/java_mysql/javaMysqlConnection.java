package java_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class javaMysqlConnection {

    // URL de la base de données. Remplacez "localhost:3306" par l'adresse de votre serveur et "usersbd" par le nom de votre base de données.
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/usersbd";

    //  Remplacez "root" par votre nom d'utilisateur.
    private static final String DATABASE_USER = "root";

    //  Remplacez "password" par votre mot de passe.
    private static final String DATABASE_PASSWORD = "";

    // La méthode getConnection établit une connexion à la base de données et la retourne.
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("La connexion à la base de données a bien été établie");
        } catch (SQLException e) {
            System.out.println("La connexion à la base de données a échoué : " + e.getMessage());
        }
        return connection;
    }
}