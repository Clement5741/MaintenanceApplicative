package User;

import java.util.Scanner;

public class GestionUser {

    public static User createAccount(Users users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom d'utilisateur: ");
        UserName userName = new UserName(scanner.nextLine());
        for (User u : users.getUtilisateurs()) {
            if (u.getNom().equals(userName.getNom())) {
                System.out.println("Nom d'utilisateur déjà utilisé.");
                return null;
            }
        }
        System.out.print("Mot de passe: ");
        UserPassword userPassword = new UserPassword(scanner.nextLine());
        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(userPassword.getMotDePasse())) {
            User user = new User(userName, userPassword);
            users.ajouterUtilisateur(user);
            return user;
        } else {
            System.out.println("Les mots de passe ne correspondent pas.");
        }
        return null;
    }

    public static User connexion(Users users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom d'utilisateur: ");
        UserName userName = new UserName(scanner.nextLine());
        System.out.print("Mot de passe: ");
        UserPassword userPassword = new UserPassword(scanner.nextLine());
        for (User u : users.getUtilisateurs()) {
            if (u.getNom().equals(userName.getNom()) && u.getMotDePasse().equals(userPassword.getMotDePasse())) {
                System.out.println("Connexion réussie.");
                return u;
            }
        }
        System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
        return null;
    }

    public static User deconnexion(User user) {
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
