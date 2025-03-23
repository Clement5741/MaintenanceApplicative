package Calendar;

import Event.ValueObjectsEvent.AllEvent.DateEvent;
import Event.Events;
import Event.Event;

import java.util.Optional;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public void addEvent(Event e) {
        events.getEvents().stream().filter(event -> conflit(e, event)).findFirst().ifPresent(event -> {
            throw new IllegalArgumentException("Conflit avec l'évènement : " + event.shortDescription());
        });
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
        Optional.of(events.ViewEvents())
                .filter(s -> !s.isEmpty())
                .ifPresentOrElse(
                        s -> System.out.println("\nListe des évènements : \n" + s),
                        () -> System.out.println("\nAucun événement")
                );
    }

    public void removeEvent(Event e) {
        events.removeEvent(e);
    }
}
