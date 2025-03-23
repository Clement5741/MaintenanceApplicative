package Event;

import Event.ValueObjectsEvent.AllEvent.DateEvent;
import Event.ValueObjectsEvent.AllEvent.DureeEvent;
import Event.ValueObjectsEvent.AllEvent.OwnerEvent;
import Event.ValueObjectsEvent.AllEvent.TitleEvent;
import Event.Type.Periodique;

public abstract class Event {
    private TitleEvent title;
    private OwnerEvent proprietaire;
    private DateEvent dateDebut;
    private DureeEvent dureeMinutes;

    public Event(TitleEvent title, OwnerEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public TitleEvent getTitle() {
        return title;
    }

    public OwnerEvent getProprietaire() {
        return proprietaire;
    }

    public DateEvent getDateDebut() {
        return dateDebut;
    }

    public DureeEvent getDureeMinutes() {
        return dureeMinutes;
    }

    public abstract String description();

    public boolean estDansPeriode(DateEvent debut, DateEvent fin) {
        return !this.getDateDebut().isBefore(debut.getDate()) && !this.getDateDebut().isAfter(fin.getDate());
    }

    public boolean conflitAvec(Event e) {
        if (e instanceof Periodique) {
            return false;
        }
        return this.getDateDebut().isBefore(e.getDateDebut().plusMinutes(e.getDureeMinutes())) && this.getDateDebut().plusMinutes(this.getDureeMinutes()).isAfter(e.getDateDebut().getDate());
    }

}