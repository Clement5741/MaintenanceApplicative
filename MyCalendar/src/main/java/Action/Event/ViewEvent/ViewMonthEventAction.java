package Action.Event.ViewEvent;

import Action.ActionInterface;
import Calendar.CalendarManager;
import Evenement.DateEvenement;
import User.User;

import java.time.LocalDateTime;
import java.util.Scanner;

import static Action.Event.ViewEventAction.afficherListe;

public class ViewMonthEventAction implements ActionInterface<User> {

    private CalendarManager calendar;

    public ViewMonthEventAction(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public User execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());

        DateEvenement debutMois = new DateEvenement(LocalDateTime.of(anneeMois, mois, 1, 0, 0));
        DateEvenement finMois = new DateEvenement(debutMois.plusMonths(1).minusSeconds(1));

        afficherListe(calendar.eventsDansPeriode(debutMois, finMois).getEvenements());
        return null;
    }
}
