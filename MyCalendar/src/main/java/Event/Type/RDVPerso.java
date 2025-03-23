package Event.Type;

import Event.*;
import Event.ValueObjectsEvent.AllEvent.DateEvent;
import Event.ValueObjectsEvent.AllEvent.DureeEvent;
import Event.ValueObjectsEvent.AllEvent.OwnerEvent;
import Event.ValueObjectsEvent.AllEvent.TitleEvent;

public class RDVPerso extends Event {


    public RDVPerso(TitleEvent titre, OwnerEvent proprietaire, DateEvent date, DureeEvent duree) {
        super(titre, proprietaire, date, duree);
    }

    @Override
    public String description() {
        return "RDV : " + this.getTitle() + " le " + this.getDateDebut() +
                " pour une durée de " + this.getDureeMinutes() +
                "\n     Propriétaire : " + this.getProprietaire();
    }

}
