package Evenement;

import java.util.ArrayList;
import java.util.List;

public class Evenements {

    private final List<Event> evenements;

    public Evenements() {
        this.evenements = new ArrayList<>();
    }

    public void ajouterEvent(Event e) {
        evenements.add(e);
    }

    public boolean contains(Event e) {
        return evenements.contains(e);
    }

    public List<Event> getEvenements() {
        return evenements;
    }
}
