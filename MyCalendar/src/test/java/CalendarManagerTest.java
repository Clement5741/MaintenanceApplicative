import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalendarManagerTest {

    @Test
    public void testAjouterEvenement() {
        CalendarManager manager = new CalendarManager();

        DateEvenement date = new DateEvenement("2025-04-01");
        HeureDebut heure = new HeureDebut("09:00");
        DureeEvenement duree = new DureeEvenement(60); // durée en minutes
        TitreEvenement titre = new TitreEvenement("Rendez-vous test");

        Evenement evenement = new RendezVousPersonnel(date, heure, duree, titre);

        manager.ajouterEvenement(evenement);

        List<Evenement> evenements = manager.getEvenementsPourPeriode(date, date);
        assertTrue("L'événement ajouté devrait être présent dans la liste", evenements.contains(evenement));
    }

}
