import Calendar.CalendarManager;
import Event.*;
import Event.Type.Birthday;
import Event.ValueObjectsEvent.AllEvent.DateEvent;
import Event.ValueObjectsEvent.AllEvent.DureeEvent;
import Event.ValueObjectsEvent.AllEvent.OwnerEvent;
import Event.ValueObjectsEvent.AllEvent.TitleEvent;
import Event.ValueObjectsEvent.Birthday.AgePerson;
import Event.ValueObjectsEvent.Birthday.NamePerson;
import Event.ValueObjectsEvent.Periodique.FrequencyDayEvent;
import Event.ValueObjectsEvent.Reunion.ParticipantsEvent;
import Event.ValueObjectsEvent.Reunion.PlaceEvent;
import Event.Type.Periodique;
import Event.Type.RDVPerso;
import Event.Type.Reunion;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarManagerTest {

    @Test
    public void testAjouterEvenementRDV() {
        CalendarManager manager = new CalendarManager();


        TitleEvent titre = new TitleEvent("Rendez-vous test");
        OwnerEvent proprietaire = new OwnerEvent("moi");
        DateEvent date = new DateEvent(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvent duree = new DureeEvent(60); // durée en minutes

        Event evenement = new RDVPerso(titre, proprietaire, date, duree);

        manager.addEvent(evenement);
        DateEvent debutJour = new DateEvent(date.getDate().minusSeconds(1));
        DateEvent finJour = new DateEvent(date.plusDays(1).minusSeconds(1));

        Events evenements = manager.eventsDansPeriode(debutJour, finJour);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

    @Test
    public void testAjouterEvenementPeriodique() {
        CalendarManager manager = new CalendarManager();

        TitleEvent titre = new TitleEvent("Rendez-vous test");
        OwnerEvent proprietaire = new OwnerEvent("moi");
        DateEvent date = new DateEvent(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvent duree = new DureeEvent(60); // durée en minutes
        FrequencyDayEvent frequence = new FrequencyDayEvent(7);

        Event evenement = new Periodique(titre, proprietaire, date, duree, frequence);

        manager.addEvent(evenement);

        Events evenements = manager.eventsDansPeriode(date, new DateEvent(date.plusDays(30)));
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

    @Test
    public void testAjouterEvenementReunion() {
        CalendarManager manager = new CalendarManager();

        TitleEvent titre = new TitleEvent("Rendez-vous test");
        OwnerEvent proprietaire = new OwnerEvent("moi");
        DateEvent date = new DateEvent(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvent duree = new DureeEvent(60); // durée en minutes
        PlaceEvent lieu = new PlaceEvent("Salle de réunion");
        ParticipantsEvent participants = new ParticipantsEvent("moi");
        participants.ajouterParticipant("toi");

        Event evenement = new Reunion(titre, proprietaire, date, duree, lieu, participants);

        manager.addEvent(evenement);

        DateEvent debutJour = new DateEvent(date.getDate().minusSeconds(1));
        DateEvent finJour = new DateEvent(date.plusDays(1).minusSeconds(1));

        Events evenements = manager.eventsDansPeriode(debutJour, finJour);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

    @Test
    public void testConflit() {
        CalendarManager manager = new CalendarManager();

        DateEvent date = new DateEvent(LocalDateTime.of(2021, 1, 1, 9, 0));
        OwnerEvent proprietaire = new OwnerEvent("moi");
        DureeEvent duree = new DureeEvent(60); // durée en minutes
        TitleEvent titre = new TitleEvent("Rendez-vous test");

        Event evenement1 = new RDVPerso(titre, proprietaire, date,  duree);
        Event evenement2 = new RDVPerso(titre, proprietaire, new DateEvent(date.plusMinutes(new DureeEvent(30))), duree);

        assertTrue(manager.conflit(evenement1, evenement2), "Les deux événements se chevauchent");
    }

    @Test
    public void testAjouterEvenementBirthday() {
        CalendarManager manager = new CalendarManager();

        TitleEvent titre = new TitleEvent("Anniversaire");
        OwnerEvent proprietaire = new OwnerEvent("moi");
        DateEvent date = new DateEvent(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvent duree = new DureeEvent(60); // durée en minutes
        NamePerson person = new NamePerson("Coco");
        AgePerson age = new AgePerson(20);


        Event evenement = new Birthday(titre, proprietaire, date, duree, person, age);

        manager.addEvent(evenement);

        DateEvent debutJour = new DateEvent(date.getDate().minusSeconds(1));
        DateEvent finJour = new DateEvent(date.plusDays(1).minusSeconds(1));

        Events evenements = manager.eventsDansPeriode(debutJour, finJour);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

}
