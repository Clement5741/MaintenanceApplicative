package Evenement.Type;

import Evenement.*;

public class Periodique extends Event {
    public FrequenceJoursEvenement frequenceJours;

    public Periodique(TitreEvenement title, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement dureeMinutes, FrequenceJoursEvenement frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "\n" +
                "Événement périodique : \n" +
                this.getTitle() + " tous les " + frequenceJours + " jours à partir du " + this.getDateDebut() +
                " pour une durée de " + this.getDureeMinutes() +
                "\nPropriétaire : " + this.getProprietaire();
    }
}
