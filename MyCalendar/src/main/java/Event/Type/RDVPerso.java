package Event.Type;

import Event.*;

public class RDVPerso extends Event {


    public RDVPerso(TitleEvent titre, OwnerEvent proprietaire, DateEvent date, DureeEvent duree) {
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
