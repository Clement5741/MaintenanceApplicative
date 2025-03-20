package Action.Event;

import Action.ActionInterface;
import Calendar.CalendarManager;
import Evenement.*;
import Evenement.Type.Reunion;
import User.User;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddReunionAction implements ActionInterface<User> {

    private User user;
    private CalendarManager calendar;

    public AddReunionAction(User user, CalendarManager calendar) {
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
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String lieu = scanner.nextLine();
        // On Vérifie que la date est valide
        if (moisRdv < 1 || moisRdv > 12 || jourRdv < 1 || jourRdv > 31 || heure < 0 || heure > 23 || minute < 0 || minute > 59) {
            System.out.println("Date invalide.");
            return user;
        }


        String participants = user.getNom();

        System.out.println("Participants : " + participants);
        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui")) {
            System.out.println("Participants : " + participants);
            System.out.print("Nom du participant : ");
            participants += ", " + scanner.nextLine();
            System.out.println("Participants : " + participants);
            System.out.println("Ajouter un participant ? (oui / non)");
        }

        calendar.ajouterEvent(new Reunion(new TitreEvenement(titre), new ProprietaireEvenement(user.getNom()), new DateEvenement(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)), new DureeEvenement(duree), new LieuEvenement(lieu), new ParticipantsEvenement(participants)));

        System.out.println("Événement ajouté.");
        return user;
    }
}
