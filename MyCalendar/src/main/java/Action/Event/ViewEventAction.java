package Action.Event;

import Action.*;
import Action.Event.ViewEvent.*;
import Event.*;
import User.*;

import java.util.*;

import Calendar.*;
public class ViewEventAction implements ActionInterface<User> {

    private User user;
    private CalendarManager calendar;

    public ViewEventAction(User user, CalendarManager calendar) {
        this.user = user;
        this.calendar = calendar;
    }

    @Override
    public User execute() {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, ActionInterface<User>> actions = new HashMap<>();
        actions.put(1, new ViewAllEventAction(calendar));
        actions.put(2, new ViewMonthEventAction(calendar));
        actions.put(3, new ViewWeekEventAction(calendar));
        actions.put(4, new ViewDayEventAction(calendar));
        actions.put(5, new BackEventAction());


        ActionInterface<User> defaultAction = new DefaultAction(user);


        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.println("==========================================");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();

        ActionInterface<User> action = actions.getOrDefault(choix, defaultAction);
        action.execute();

        return user;
    }

    public static void afficherListe(List<Event> events) {
        Optional.of(events)
                .filter(list -> !list.isEmpty())
                .ifPresentOrElse(
                        list -> {
                            System.out.println("\nListe des évènements : ");
                            list.forEach(e -> System.out.println(e.description()));
                        },
                        () -> System.out.println("Aucun événement trouvé pour cette période.")
                );
    }
}
