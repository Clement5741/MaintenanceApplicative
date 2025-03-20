package Evenement;

public abstract class Event {
    private TitreEvenement title;
    private ProprietaireEvenement proprietaire;
    private DateEvenement dateDebut;
    private DureeEvenement dureeMinutes;

    public Event(TitreEvenement title, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public TitreEvenement getTitle() {
        return title;
    }

    public ProprietaireEvenement getProprietaire() {
        return proprietaire;
    }

    public DateEvenement getDateDebut() {
        return dateDebut;
    }

    public DureeEvenement getDureeMinutes() {
        return dureeMinutes;
    }

    public abstract String description();
}