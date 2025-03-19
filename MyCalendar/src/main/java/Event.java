public abstract class Event {
    public TitreEvenement title;
    public ProprietaireEvenement proprietaire;
    public DateEvenement dateDebut;
    public DureeEvenement dureeMinutes;

    public Event(TitreEvenement title, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }


    public abstract String description();
}