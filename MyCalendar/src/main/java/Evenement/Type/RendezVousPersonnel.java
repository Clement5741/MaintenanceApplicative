package Evenement.Type;

import Evenement.*;

public class RendezVousPersonnel extends Event {


    public RendezVousPersonnel(TitreEvenement titre, ProprietaireEvenement proprietaire, DateEvenement date, DureeEvenement duree) {
        super(titre, proprietaire, date, duree);
    }

    @Override
    public String description() {
        return "\n" +
                "RDV : " + this.getTitle() + " le " + this.getDateDebut() +
                " pour une durée de " + this.getDureeMinutes() +
                "\nPropriétaire : " + this.getProprietaire();
    }

}
