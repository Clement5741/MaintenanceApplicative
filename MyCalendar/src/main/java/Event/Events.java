package Event;

import java.util.ArrayList;
import java.util.List;

public class Events {

    private final List<Event> events;

    public Events() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event e) {
        events.add(e);
    }

    public boolean contains(Event e) {
        return events.contains(e);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEventIfInPeriod(Event e, DateEvent debut, DateEvent fin) {
        if (e.estDansPeriode(debut, fin)) {
            events.add(e);
        }
    }

    public String ViewEvents() {
        StringBuilder sb = new StringBuilder();
        for (Event e : events) {
            sb.append(e.description()).append("\n");
        }
        return sb.toString();
    }
}
