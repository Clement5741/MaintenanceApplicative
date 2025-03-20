package Calendar;

import Evenement.DateEvenement;
import Evenement.Evenements;
import Evenement.Event;
import Evenement.Type.Periodique;

import java.time.LocalDateTime;

public class CalendarManager {
    public Evenements events;

    public CalendarManager() {
        this.events = new Evenements();
    }

    public void ajouterEvent(Event e) {
        events.ajouterEvent(e);
    }

    public Evenements getEvenements() {
        return events;
    }

    public Evenements eventsDansPeriode(DateEvenement debut, DateEvenement fin) {
        Evenements result = new Evenements();
        for (Event e : events.getEvenements()) {
            if (e instanceof Periodique) {
                LocalDateTime temp = e.getDateDebut().getDate();
                while (temp.isBefore(fin.getDate())) {
                    if (!temp.isBefore(debut.getDate())) {
                        result.ajouterEvent(e);
                        break;
                    }
                    temp = temp.plusDays(((Periodique) e).frequenceJours.getFrequenceJours());
                }
            } else if (!e.getDateDebut().isBefore(debut.getDate()) && !e.getDateDebut().isAfter(fin.getDate())) {
                result.ajouterEvent(e);
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

        if (e1.getDateDebut().isBefore(fin2) && fin1.isAfter(e2.getDateDebut().getDate())) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events.getEvenements()) {
            System.out.println(e.description());
        }
        if (events.getEvenements().isEmpty()) {
            System.out.println("Aucun événement");
        }
    }
}