package Action.Event.ViewEvent;

import Action.ActionInterface;
import Calendar.CalendarManager;
import Evenement.DateEvenement;
import User.User;

import java.time.LocalDateTime;
import java.util.Scanner;

import static Action.Event.ViewEventAction.afficherListe;

public class ViewDayEventAction implements ActionInterface<User> {

    private CalendarManager calendar;

    public ViewDayEventAction(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public User execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        DateEvenement debutJour = new DateEvenement(LocalDateTime.of(anneeJour, moisJour, jour, 0, 0));
        DateEvenement finJour = new DateEvenement(debutJour.plusDays(1).minusSeconds(1));

        afficherListe(calendar.eventsDansPeriode(debutJour, finJour).getEvenements());
        return null;
    }
}
