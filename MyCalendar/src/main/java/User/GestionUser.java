package User;

import java.util.Scanner;

public class GestionUser {

    public static User createAccount(Users users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom d'utilisateur: ");
        UserName userName = new UserName(scanner.nextLine());
        for (User u : users.getUsers()) {
            if (u.getName().equals(userName.getName())) {
                System.out.println("Nom d'utilisateur déjà utilisé.");
                return null;
            }
        }
        System.out.print("Mot de passe: ");
        UserPassword userPassword = new UserPassword(scanner.nextLine());
        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(userPassword.getPassword())) {
            User user = new User(userName, userPassword);
            users.addUser(user);
            return user;
        } else {
            System.out.println("Les mots de passe ne correspondent pas.");
        }
        return null;
    }

    public static User connection(Users users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom d'utilisateur: ");
        UserName userName = new UserName(scanner.nextLine());
        System.out.print("Mot de passe: ");
        UserPassword userPassword = new UserPassword(scanner.nextLine());
        for (User u : users.getUsers()) {
            if (u.getName().equals(userName.getName()) && u.getPassword().equals(userPassword.getPassword())) {
                System.out.println("Connexion réussie.");
                return u;
            }
        }
        System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
        return null;
    }

    public static User disconnect(User user) {
        // Demande de confirmation
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous vraiment vous déconnecter ? (oui / non)");
        if (scanner.nextLine().equals("oui")) {
            System.out.println("Déconnexion réussie.");
            return null;
        }
        System.out.println("Déconnexion annulée.");
        return user;
    }

}
