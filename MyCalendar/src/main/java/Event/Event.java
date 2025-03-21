package Event;

public abstract class Event {
    private TitleEvent title;
    private OwnerEvent proprietaire;
    private DateEvent dateDebut;
    private DureeEvent dureeMinutes;

    public Event(TitleEvent title, OwnerEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public TitleEvent getTitle() {
        return title;
    }

    public OwnerEvent getProprietaire() {
        return proprietaire;
    }

    public DateEvent getDateDebut() {
        return dateDebut;
    }

    public DureeEvent getDureeMinutes() {
        return dureeMinutes;
    }

    public abstract String description();
}