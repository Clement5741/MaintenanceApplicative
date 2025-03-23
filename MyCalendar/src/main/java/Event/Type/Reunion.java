package Event.Type;

import Event.*;
import Event.ValueObjectsEvent.AllEvent.DateEvent;
import Event.ValueObjectsEvent.AllEvent.DureeEvent;
import Event.ValueObjectsEvent.AllEvent.OwnerEvent;
import Event.ValueObjectsEvent.AllEvent.TitleEvent;
import Event.ValueObjectsEvent.Reunion.ParticipantsEvent;
import Event.ValueObjectsEvent.Reunion.PlaceEvent;

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
        return "Réunion : " + this.getTitle() + " dans " + lieu +
                " le " + this.getDateDebut().toString() +
                " pour une durée de " + this.getDureeMinutes() +
                "\n     Propriétaire : " + this.getProprietaire() +
                "\n     Participants : " + this.participants +
                "\n" + super.description();
    }

    @Override
    public String shortDescription() {
        return "Réunion : " + this.getTitle() + " le " + this.getDateDebut() + " pour une durée de " + this.getDureeMinutes();
    }

}
