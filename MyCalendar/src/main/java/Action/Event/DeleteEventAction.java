package Action.Event;

import Action.ActionInterface;
import Calendar.CalendarManager;
import Event.Event;
import User.User;

import java.util.Scanner;

public class DeleteEventAction implements ActionInterface<User> {

    private User user;

    private CalendarManager calendar;

    public DeleteEventAction(User user, CalendarManager calendar) {
        this.user = user;
        this.calendar = calendar;
    }

    @Override
    public User execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'identifiant de l'événement à supprimer : ");
        String eventId = scanner.nextLine();
        Event e = null;
        for (Event event : calendar.events.getEvents()) {
            if (event.getEventId().getId().equals(eventId)) {
                e = event;
            }
        }
        if (e == null) {
            System.out.println("Aucun événement trouvé avec cet identifiant.");
            return user;
        }
        calendar.removeEvent(e);
        System.out.println("Evénement supprimé.");

        return user;
    }

    @Override
    public String toString() {
        return "Supprimer un événement avec son EventId";
    }
}
