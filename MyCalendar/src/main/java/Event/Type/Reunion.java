package Event.Type;

import Event.*;

public class Reunion extends Event {

    private PlaceEvent lieu;

    private ParticipantsEvent participants;

    public Reunion(TitleEvent title, OwnerEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes, PlaceEvent lieu, ParticipantsEvent participants) {
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
