import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Test de la classe CalendarManager
public class CalendarManagerTest {

    @Test
    public void testAjouterEvenement() {
        CalendarManager manager = new CalendarManager();


        DateEvenement date = new DateEvenement(LocalDateTime.of(2021, 1, 1, 9, 0));
        DureeEvenement duree = new DureeEvenement(60); // durée en minutes
        TitreEvenement titre = new TitreEvenement("Rendez-vous test");

        Event evenement = new RendezVousPersonnel(date, duree, titre);

        manager.ajouterEvent(evenement);

        List<Event> evenements = manager.getEvenementsPourPeriode(date, date);
        assertTrue("L'événement ajouté devrait être présent dans la liste", evenements.contains(evenement));
    }

}
