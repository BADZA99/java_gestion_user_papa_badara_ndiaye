package entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String password;
    private String passwordHashed;
    private String email;
    private int role_id;

    // Constructeur
    public User(String passwordHashed, String password, String email, int role_id) {
        this.password = password;
        this.passwordHashed = passwordHashed;
        this.email = email;
        this.role_id = role_id;
    }

    // String hashedPassword = hashPassword(password);
    // Méthode pour créer un utilisateur
    public static User createUser(String passwordHashed, String password, String email, int role_id) {
        return new User(passwordHashed, password, email, role_id);
    }

    // Méthode pour hacher le mot de passe
    public static String hashPassword(String passwordToHash) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(passwordToHash.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}