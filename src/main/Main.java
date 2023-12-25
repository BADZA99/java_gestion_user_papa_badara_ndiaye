package main;

import entities.User;
import java_mysql.javaMysqlConnection;
import java_mysql.Request;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // tester la connection
        javaMysqlConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        String password;
        String passwordHashed;
        String email;
        int role_id;
        int choice;

        do {
            System.out.println("1. Inserer un utilisateur");
            System.out.println("2. Afficher les rôles");
            System.out.println("3. Afficher les utilisateurs");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // saisir user 
                    do {
                        System.out.print("Saisissez un mot de passe : ");
                        password = scanner.next();
                    } while (password.length() < 8);
                    System.out.println(password);
                    do {
                        System.out.print("Saisissez un email : ");
                        email = scanner.next();
                    } while (email.length() < 8);
                    do {
                        Request.displayRoles();
                        System.out.print("choisir l'id d'un rôle : ");
                        role_id = scanner.nextInt();
                    } while (role_id < 1 || role_id > 3);
                    // HASHER LE MOT DE PASSE 
                     passwordHashed = User.hashPassword(password);
                    // creer un user avec ses attribut
                    User.createUser(passwordHashed,password, email, role_id);
                    System.out.println("L'utilisateur a bien été créé avec succes");
                    //  inserer user dans la base de donnée
                    Request.insertUser(password, passwordHashed, email, role_id);
                    break;
                case 2:
                    Request.displayRoles();
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}