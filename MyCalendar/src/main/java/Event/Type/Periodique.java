package Event.Type;

import Event.*;
import Event.ValueObjectsEvent.AllEvent.DateEvent;
import Event.ValueObjectsEvent.AllEvent.DureeEvent;
import Event.ValueObjectsEvent.AllEvent.OwnerEvent;
import Event.ValueObjectsEvent.AllEvent.TitleEvent;
import Event.ValueObjectsEvent.Periodique.FrequencyDayEvent;

import java.time.LocalDateTime;

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
        return "Événement périodique : \n" +
                this.getTitle() + " tous les " + frequencyDayEvent +
                " jours à partir du " + this.getDateDebut() +
                " pour une durée de " + this.getDureeMinutes() +
                "\n     Propriétaire : " + this.getProprietaire();
    }

    @Override
    public String shortDescription() {
        return "Événement périodique : " + this.getTitle() + " du " + this.getDateDebut() + " pour une durée de " + this.getDureeMinutes();
    }

    @Override
    public boolean estDansPeriode(DateEvent debut, DateEvent fin) {
        Events result = new Events();
        LocalDateTime temp = this.getDateDebut().getDate();
        while (temp.isBefore(fin.getDate())) {
            if (!temp.isBefore(debut.getDate())) {
                result.addEvent(this);
                break;
            }
            temp = temp.plusDays(this.getFrequencyDayEvent().getFrequenceJours());
        }
        return !result.getEvents().isEmpty();
    }

    public boolean conflitAvec(Event e) {
        return false;
    }

}
