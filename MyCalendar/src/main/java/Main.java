import Action.*;
import Action.Event.*;
import Action.GestionUser.*;
import ChoixScanner.ChoixScanner;
import User.*;
import Calendar.*;

import java.util.*;

// Fin Séance CHAUVEL
public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        User user = null;
        ChoixScanner choixScanner = new ChoixScanner();

        Users users = new Users();

        while (true) {
            afficherMenuBase();

            ListAction listActionConnection = new ListAction();

            listActionConnection.addAction(1, new ConnectionAction(users));
            listActionConnection.addAction(2, new CreateAccountAction(users));

            ActionInterface<User> defaultAction = new DefaultAction(user);


            System.out.println("1 - Se connecter");
            System.out.println("2 - Créer un compte");
            System.out.print("Choix : ");
            choixScanner.setChoixInt(scanner.nextInt());

            ActionInterface<User> actionConnection = listActionConnection.getOrDefault(choixScanner.getChoixInt(), defaultAction);
            user = actionConnection.execute();

            while (user != null) {

                ListAction listActionAfterConnection = new ListAction();

                listActionAfterConnection.addAction(1, new ViewEventAction(user, calendar));
                listActionAfterConnection.addAction(2, new AddRDVAction(user, calendar));
                listActionAfterConnection.addAction(3, new AddReunionAction(user, calendar));
                listActionAfterConnection.addAction(4, new AddPeriodiqueAction(user, calendar));
                listActionAfterConnection.addAction(5, new DisconnectAction(user));

                System.out.println("\nBonjour, " + user.getName());
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.println("======================================");
                System.out.print("Votre choix : ");

                choixScanner.setChoixInt(scanner.nextInt());

                ActionInterface<User> actionAfterConnection = listActionAfterConnection.getOrDefault(choixScanner.getChoixInt(), defaultAction);
                user = actionAfterConnection.execute();
            }
        }
    }

    private static void afficherMenuBase() {
        System.out.println(
                """
                          _____         _                   _                __  __
                         / ____|       | |                 | |              |  \\/  |
                        | |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __
                        | |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|
                        | |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |
                         \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|
                                                                                                           __/ |
                                                                                                          |___/""");
    }
}
