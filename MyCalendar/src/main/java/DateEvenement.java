import java.time.LocalDateTime;

public class DateEvenement {

    private LocalDateTime date;

    public DateEvenement(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isBefore(LocalDateTime debut) {
        return date.isBefore(debut);
    }

    public boolean isAfter(LocalDateTime fin) {
        return date.isAfter(fin);
    }

    public LocalDateTime plusMinutes(DureeEvenement dureeMinutes) {
        return date.plusMinutes(dureeMinutes.getDuree());
    }

    public LocalDateTime plusMonths(int i) {
        return date.plusMonths(i);
    }

    public LocalDateTime plusDays(int i) {
        return date.plusDays(i);
    }
}
