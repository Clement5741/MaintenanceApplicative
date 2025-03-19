import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarManagerTest {

    @Test
    public void testAjouterEvenement() {
        CalendarManager manager = new CalendarManager();


        DateEvenement date = new DateEvenement(LocalDateTime.of(2021, 1, 1, 9, 0));
        ProprietaireEvenement proprietaire = new ProprietaireEvenement("moi");
        DureeEvenement duree = new DureeEvenement(60); // durée en minutes
        TitreEvenement titre = new TitreEvenement("Rendez-vous test");

        Event evenement = new RendezVousPersonnel(date, proprietaire, duree, titre);

        manager.ajouterEvent(evenement);

        Evenements evenements = manager.eventsDansPeriode(date, date);
        assertTrue(evenements.contains(evenement), "L'événement ajouté doit être présent");

    }

}
