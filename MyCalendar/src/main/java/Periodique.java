public class Periodique extends Event {
    public FrequenceJoursEvenement frequenceJours;

    public Periodique(TitreEvenement title, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement dureeMinutes, FrequenceJoursEvenement frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
