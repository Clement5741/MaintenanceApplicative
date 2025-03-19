import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public Evenements events;

    public CalendarManager() {
        this.events = new Evenements();
    }

    public void ajouterEvent(Event e) {
        events.ajouterEvent(e);
    }

    public Evenements eventsDansPeriode(DateEvenement debut, DateEvenement fin) {
        Evenements result = new Evenements();
        for (Event e : events.getEvenements()) {
            if (e instanceof Periodique) {
                LocalDateTime temp = e.dateDebut.getDate();
                while (temp.isBefore(fin.getDate())) {
                    if (!temp.isBefore(debut.getDate())) {
                        result.ajouterEvent(e);
                        break;
                    }
                    temp = temp.plusDays(((Periodique) e).frequenceJours.getFrequenceJours());
                }
            } else if (!e.dateDebut.isBefore(debut.getDate()) && !e.dateDebut.isAfter(fin.getDate())) {
                result.ajouterEvent(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.dureeMinutes);
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.dureeMinutes);

        if (e1 instanceof Periodique || e2 instanceof Periodique) {
            return false; // Simplification abusive
        }

        if (e1.dateDebut.isBefore(fin2) && fin1.isAfter(e2.dateDebut.getDate())) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events.getEvenements()) {
            System.out.println(e.description());
        }
    }
}