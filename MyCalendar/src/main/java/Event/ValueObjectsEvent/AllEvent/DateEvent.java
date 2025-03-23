package Event.ValueObjectsEvent.AllEvent;

import java.time.LocalDateTime;

public class DateEvent {

    private LocalDateTime date;

    public DateEvent(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isBefore(LocalDateTime debut) {
        return date.isBefore(debut);
    }

    public boolean isAfter(LocalDateTime fin) {
        return date.isAfter(fin);
    }

    public LocalDateTime plusMinutes(DureeEvent dureeMinutes) {
        return date.plusMinutes(dureeMinutes.getDuree());
    }

    public LocalDateTime plusMonths(int i) {
        return date.plusMonths(i);
    }

    public LocalDateTime plusDays(int i) {
        return date.plusDays(i);
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
