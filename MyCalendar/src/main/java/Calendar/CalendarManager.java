package Calendar;

import Event.DateEvent;
import Event.Events;
import Event.Event;
import java.util.Optional;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public void addEvent(Event e) {
        events.addEvent(e);
    }

    public Events eventsDansPeriode(DateEvent debut, DateEvent fin) {
        Events result = new Events();
        for (Event e : events.getEvents()) {
            result.addEventIfInPeriod(e, debut, fin);
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        return e1.conflitAvec(e2);
    }

    public void afficherEvenements() {
        Optional.of(events.getEvents())
                .filter(list -> !list.isEmpty())
                .ifPresentOrElse(
                        list -> {
                            System.out.println("\nListe des évènements : ");
                            list.forEach(e -> System.out.println(e.description()));
                        },
                        () -> System.out.println("Aucun événement")
                );
    }
}