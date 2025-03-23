package Action.Event.ViewEvent;

import Action.ActionInterface;
import Calendar.CalendarManager;
import Event.ValueObjectsEvent.AllEvent.DateEvent;
import User.User;

import java.time.LocalDateTime;
import java.util.Scanner;

import static Action.Event.ViewEventAction.afficherListe;

public class ViewEventInPeriodAction implements ActionInterface<User> {

    private CalendarManager calendar;

    public ViewEventInPeriodAction(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public User execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez la date de début de la période : ");
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        System.out.println("Entrez la date de fin de la période : ");
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeFin = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int moisFin = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jourFin = Integer.parseInt(scanner.nextLine());


        DateEvent debutJour = new DateEvent(LocalDateTime.of(anneeJour, moisJour, jour, 0, 0));
        DateEvent finJour = new DateEvent(LocalDateTime.of(anneeFin, moisFin, jourFin, 23, 59));

        afficherListe(calendar.eventsDansPeriode(debutJour, finJour));

        return null;
    }

    @Override
    public String toString() {
        return "Voir les événements dans une période précise";
    }
}
