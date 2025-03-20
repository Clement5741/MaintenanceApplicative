import Action.*;
import Action.Event.*;
import Action.GestionUser.*;
import User.*;
import Calendar.*;

import java.util.*;

// Fin Séance CHAUVEL
public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        User user = null;
        boolean continuer = true;

        Users users = new Users();

        while (true) {
            if (user == null) {
                afficherMenuBase();

                Map<Integer, ActionInterface<User>> actions = new HashMap<>();
                actions.put(1, new ConnexionAction(users));
                actions.put(2, new CreateAccountAction(users));

                ActionInterface<User> defaultAction = new DefaultAction(user);


                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.println("Choix : ");
                int choix = scanner.nextInt();

                ActionInterface<User> action = actions.getOrDefault(choix, defaultAction);
                user = action.execute();
            }

            while (continuer && user != null) {

                Map<Integer, ActionInterface<User>> actions = new HashMap<>();
                actions.put(1, new ViewEventAction(user, calendar));
                actions.put(2, new AddRDVAction(user, calendar));
                actions.put(3, new AddReunionAction(user, calendar));
                actions.put(4, new AddPeriodiqueAction(user, calendar));
                actions.put(5, new DeconnexionAction(user));

                ActionInterface<User> defaultAction = new DefaultAction(user);

                System.out.println("\nBonjour, " + user.getNom());
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");

                int choix = scanner.nextInt();

                ActionInterface<User> action = actions.getOrDefault(choix, defaultAction);
                user = action.execute();
            }
        }
    }

    private static void afficherMenuBase() {
        System.out.println("  _____         _                   _                __  __");
        System.out.println(" / ____|       | |                 | |              |  \\/  |");
        System.out.println(
                "| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
        System.out.println(
                "| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
        System.out.println(
                "| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
        System.out.println(
                " \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
        System.out.println(
                "                                                                                   __/ |");
        System.out.println(
                "                                                                                  |___/");
    }
}
