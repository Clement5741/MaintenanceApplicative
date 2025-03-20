package Action.Event;

import Action.ActionInterface;
import Calendar.CalendarManager;
import Evenement.*;
import Evenement.Type.Periodique;
import User.User;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddPeriodiqueAction implements ActionInterface<User> {

    private User user;
    private CalendarManager calendar;

    public AddPeriodiqueAction(User user, CalendarManager calendar) {
        this.user = user;
        this.calendar = calendar;
    }

    @Override
    public User execute() {
        // Ajout simplifié d'une réunion
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());
        // On Vérifie que la date est valide
        if (moisRdv < 1 || moisRdv > 12 || jourRdv < 1 || jourRdv > 31 || heure < 0 || heure > 23 || minute < 0 || minute > 59) {
            System.out.println("Date invalide.");
            return user;
        }

        calendar.ajouterEvent(new Periodique(new TitreEvenement(titre), new ProprietaireEvenement(user.getNom()), new DateEvenement(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)), new DureeEvenement(0), new FrequenceJoursEvenement(frequence)));

        System.out.println("Événement ajouté.");
        return user;
    }
}
