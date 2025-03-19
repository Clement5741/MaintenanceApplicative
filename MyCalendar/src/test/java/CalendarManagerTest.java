import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarManagerTest {

    @Test
    public void testAjouterEvenementRDV() {
        CalendarManager manager = new CalendarManager();


        TitreEvenement titre = new TitreEvenement("Rendez-vous test");
        ProprietaireEvenement proprietaire = new ProprietaireEvenement("moi");
        DateEvenement date = new DateEvenement(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvenement duree = new DureeEvenement(60); // durée en minutes

        Event evenement = new RendezVousPersonnel(titre, proprietaire, date, duree);

        manager.ajouterEvent(evenement);

        Evenements evenements = manager.eventsDansPeriode(date, date);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

    @Test
    public void testAjouterEvenementPeriodique() {
        CalendarManager manager = new CalendarManager();

        TitreEvenement titre = new TitreEvenement("Rendez-vous test");
        ProprietaireEvenement proprietaire = new ProprietaireEvenement("moi");
        DateEvenement date = new DateEvenement(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvenement duree = new DureeEvenement(60); // durée en minutes
        FrequenceJoursEvenement frequence = new FrequenceJoursEvenement(7);

        Event evenement = new Periodique(titre, proprietaire, date, duree, frequence);

        manager.ajouterEvent(evenement);

        Evenements evenements = manager.eventsDansPeriode(date, new DateEvenement(date.plusDays(30)));
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

    @Test
    public void testAjouterEvenementReunion() {
        CalendarManager manager = new CalendarManager();

        TitreEvenement titre = new TitreEvenement("Rendez-vous test");
        ProprietaireEvenement proprietaire = new ProprietaireEvenement("moi");
        DateEvenement date = new DateEvenement(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvenement duree = new DureeEvenement(60); // durée en minutes
        LieuEvenement lieu = new LieuEvenement("Salle de réunion");
        ParticipantsEvenement participants = new ParticipantsEvenement("moi");
        participants.ajouterParticipant("toi");

        Event evenement = new Reunion(titre, proprietaire, date, duree, lieu, participants);

        manager.ajouterEvent(evenement);

        Evenements evenements = manager.eventsDansPeriode(date, date);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");
    }

    @Test
    public void testConflit() {
        CalendarManager manager = new CalendarManager();

        DateEvenement date = new DateEvenement(LocalDateTime.of(2021, 1, 1, 9, 0));
        ProprietaireEvenement proprietaire = new ProprietaireEvenement("moi");
        DureeEvenement duree = new DureeEvenement(60); // durée en minutes
        TitreEvenement titre = new TitreEvenement("Rendez-vous test");

        Event evenement1 = new RendezVousPersonnel(titre, proprietaire, date,  duree);
        Event evenement2 = new RendezVousPersonnel(titre, proprietaire, new DateEvenement(date.plusMinutes(new DureeEvenement(30))), duree);

        assertTrue(manager.conflit(evenement1, evenement2), "Les deux événements se chevauchent");
    }

}
