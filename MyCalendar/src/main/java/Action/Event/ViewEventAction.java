package Action.Event;

import Action.*;
import Action.Event.ViewEvent.*;
import ChoixScanner.ChoixScanner;
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
        ChoixScanner choixScanner = new ChoixScanner();

        ListActionViewEvent listActionViewEvent = new ListActionViewEvent(calendar);
        ActionInterface<User> defaultAction = new DefaultAction(user);
        listActionViewEvent.afficherMenu();

        choixScanner.setChoixInt(scanner.nextInt());

        ActionInterface<User> action = listActionViewEvent.getOrDefault(choixScanner.getChoixInt(), defaultAction);
        action.execute();

        return user;
    }

    public static void afficherListe(Events events) {
        Optional.of(events.ViewEvents())
                .filter(s -> !s.isEmpty())
                .ifPresentOrElse(
                        s -> System.out.println("\nListe des évènements : \n" + s),
                        () -> System.out.println("\nAucun événement trouvé pour cette période.")
                );
    }

    @Override
    public String toString() {
        return "Voir les événements";
    }
}
