package Action.Event;

import Action.ActionInterface;
import Calendar.CalendarManager;
import Event.Type.Birthday;
import Event.ValueObjectsEvent.AllEvent.*;
import Event.ValueObjectsEvent.Birthday.*;
import User.User;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddBirthdayAction implements ActionInterface<User> {

    private User user;

    private CalendarManager calendar;

    public AddBirthdayAction(User user, CalendarManager calendar) {
        this.user = user;
        this.calendar = calendar;
    }

    @Override
    public User execute() {
        // Ajout simplifié d'une anniversaire
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
        System.out.print("Nom de la personne : ");
        String nom = scanner.nextLine();
        System.out.print("Age de la personne : ");
        int age = Integer.parseInt(scanner.nextLine());
        // On Vérifie que la date est valide
        if (moisRdv < 1 || moisRdv > 12 || jourRdv < 1 || jourRdv > 31 || heure < 0 || heure > 23 || minute < 0 || minute > 59) {
            System.out.println("Date invalide.");
            return user;
        }

        try {
            calendar.addEvent(new Birthday(new TitleEvent(titre), new OwnerEvent(user.getName()), new DateEvent(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)), new DureeEvent(0), new NamePerson(nom), new AgePerson(age)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return user;
        }

        System.out.println("Événement ajouté.");
        return user;
    }

    @Override
    public String toString() {
        return "Ajouter un anniversaire";
    }
}
