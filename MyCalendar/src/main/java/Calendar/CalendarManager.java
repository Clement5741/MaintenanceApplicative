package Calendar;

import Event.DateEvent;
import Event.Events;
import Event.Event;
import Event.Type.Periodique;

import java.time.LocalDateTime;

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
            if (e instanceof Periodique) {
                LocalDateTime temp = e.getDateDebut().getDate();
                while (temp.isBefore(fin.getDate())) {
                    if (!temp.isBefore(debut.getDate())) {
                        result.addEvent(e);
                        break;
                    }
                    temp = temp.plusDays(((Periodique) e).getFrequencyDayEvent().getFrequenceJours());
                }
            } else if (!e.getDateDebut().isBefore(debut.getDate()) && !e.getDateDebut().isAfter(fin.getDate())) {
                result.addEvent(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.getDateDebut().plusMinutes(e1.getDureeMinutes());
        LocalDateTime fin2 = e2.getDateDebut().plusMinutes(e2.getDureeMinutes());

        if (e1 instanceof Periodique || e2 instanceof Periodique) {
            return false; // Simplification abusive
        }

        return e1.getDateDebut().isBefore(fin2) && fin1.isAfter(e2.getDateDebut().getDate());
    }

    public void afficherEvenements() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
        if (events.getEvents().isEmpty()) {
            System.out.println("Aucun événement");
        }
    }
}