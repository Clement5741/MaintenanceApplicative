package Action.Event.ViewEvent;

import Action.ActionInterface;
import Calendar.CalendarManager;
import Evenement.DateEvenement;
import User.User;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

import static Action.Event.ViewEventAction.afficherListe;

public class ViewWeekEventAction implements ActionInterface<User> {

    private CalendarManager calendar;

    public ViewWeekEventAction(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public User execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'année (AAAA) : ");
        int anneeSemaine = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.nextLine());

        DateEvenement debutSemaine = new DateEvenement(LocalDateTime.now()
                .withYear(anneeSemaine)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0));
        DateEvenement finSemaine = new DateEvenement(debutSemaine.plusDays(7).minusSeconds(1));

        afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine).getEvenements());
        return null;
    }
}
