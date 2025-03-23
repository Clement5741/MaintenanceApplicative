import Action.*;
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
        ActionInterface<User> defaultAction;

        while (true) {
            afficherMenuBase();

            ListAction listActionConnection = new ListActionConnection(users);
            defaultAction = new DefaultAction(user);
            listActionConnection.afficherMenu();

            choixScanner.setChoixInt(scanner.nextInt());

            ActionInterface<User> actionConnection = listActionConnection.getOrDefault(choixScanner.getChoixInt(), defaultAction);
            user = actionConnection.execute();

            while (user != null) {

                ListAction listActionEvent = new ListActionEvent(user, calendar);
                defaultAction= new DefaultAction(user);
                listActionEvent.afficherMenu();

                choixScanner.setChoixInt(scanner.nextInt());

                ActionInterface<User> actionAfterConnection = listActionEvent.getOrDefault(choixScanner.getChoixInt(), defaultAction);
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
