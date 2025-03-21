package Event.Type;

import Event.*;

public class Periodique extends Event {
    private FrequencyDayEvent frequencyDayEvent;

    public Periodique(TitleEvent title, OwnerEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes, FrequencyDayEvent frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequencyDayEvent = frequenceJours;
    }

    public FrequencyDayEvent getFrequencyDayEvent() {
        return frequencyDayEvent;
    }

    @Override
    public String description() {
        return "\n" +
                "Événement périodique : \n" +
                this.getTitle() + " tous les " + frequencyDayEvent + " jours à partir du " + this.getDateDebut() +
                " pour une durée de " + this.getDureeMinutes() +
                "\nPropriétaire : " + this.getProprietaire();
    }
}
