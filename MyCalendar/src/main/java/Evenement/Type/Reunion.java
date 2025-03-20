package Evenement.Type;

import Evenement.*;

public class Reunion extends Event {

    private LieuEvenement lieu;

    private ParticipantsEvenement participants;

    public Reunion(TitreEvenement title, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement dureeMinutes, LieuEvenement lieu, ParticipantsEvenement participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "\n" +
                "Réunion : " + this.getTitle() + " dans " + lieu + " le " + this.getDateDebut().toString() +
                " pour une durée de " + this.getDureeMinutes() +
                "\nPropriétaire : " + this.getProprietaire() +
                "\nParticipants : " + this.participants;
    }


}
