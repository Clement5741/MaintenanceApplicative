import Calendar.CalendarManager;
import Event.*;
import Event.ValueObjectsEvent.AllEvent.*;
import Event.ValueObjectsEvent.Birthday.*;
import Event.ValueObjectsEvent.Periodique.FrequencyDayEvent;
import Event.ValueObjectsEvent.Reunion.*;
import Event.Type.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarManagerTest {

    private CalendarManager manager;

    @BeforeEach
    public void setUp() {
        System.out.println("Début des tests de la classe CalendarManager");
        manager = new CalendarManager();
    }

    @Test
    public void testAjouterEvenementRDV() {
        TitleEvent titre = new TitleEvent("Rendez-vous test");
        OwnerEvent proprietaire = new OwnerEvent("moi");
        DateEvent date = new DateEvent(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvent duree = new DureeEvent(60); // durée en minutes

        Event evenement = new RDVPerso(titre, proprietaire, date, duree);

        manager.addEvent(evenement);

        Events evenements = manager.eventsDansPeriode(date, date);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

    @Test
    public void testAjouterEvenementPeriodique() {
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
        TitleEvent titre = new TitleEvent("Rendez-vous test");
        OwnerEvent proprietaire = new OwnerEvent("moi");
        DateEvent date = new DateEvent(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvent duree = new DureeEvent(60); // durée en minutes
        PlaceEvent lieu = new PlaceEvent("Salle de réunion");
        ParticipantsEvent participants = new ParticipantsEvent("moi");
        participants.ajouterParticipant("toi");

        Event evenement = new Reunion(titre, proprietaire, date, duree, lieu, participants);

        manager.addEvent(evenement);

        Events evenements = manager.eventsDansPeriode(date, date);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

    @Test
    public void testConflit() {
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
        TitleEvent titre = new TitleEvent("Anniversaire");
        OwnerEvent proprietaire = new OwnerEvent("moi");
        DateEvent date = new DateEvent(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvent duree = new DureeEvent(60); // durée en minutes
        NamePerson person = new NamePerson("Coco");
        AgePerson age = new AgePerson(20);


        Event evenement = new Birthday(titre, proprietaire, date, duree, person, age);

        manager.addEvent(evenement);

        Events evenements = manager.eventsDansPeriode(date, date);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

}
