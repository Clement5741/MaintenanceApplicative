package Action.Event;

import Action.*;
import Action.Event.ViewEvent.*;
import Event.*;
import User.*;

import java.util.*;

import Calendar.*;
public class ViewEventAction implements ActionInterface<User> {

    private User user;
    private CalendarManager calendar;

    public ViewEventAction(User user, CalendarManager calendar) {
        this.user = user;
        this.calendar = calendar;
    }

    @Override
    public User execute() {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, ActionInterface<User>> actions = new HashMap<>();
        actions.put(1, new ViewAllEventAction(calendar));
        actions.put(2, new ViewMonthEventAction(calendar));
        actions.put(3, new ViewWeekEventAction(calendar));
        actions.put(4, new ViewDayEventAction(calendar));

        ActionInterface<User> defaultAction = new DefaultAction(user);


        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.println("==========================================");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();

        ActionInterface<User> action = actions.getOrDefault(choix, defaultAction);
        action.execute();

//        switch (choix) {
//            case "1":
//                calendar.afficherEvenements();
//                break;
//
//            case "2":
//                System.out.print("Entrez l'année (AAAA) : ");
//                int anneeMois = Integer.parseInt(scanner.nextLine());
//                System.out.print("Entrez le mois (1-12) : ");
//                int mois = Integer.parseInt(scanner.nextLine());
//
//                DateEvenement debutMois = new DateEvenement(LocalDateTime.of(anneeMois, mois, 1, 0, 0));
//                DateEvenement finMois = new DateEvenement(debutMois.plusMonths(1).minusSeconds(1));
//
//                afficherListe(calendar.eventsDansPeriode(debutMois, finMois).getEvenements());
//                break;
//
//            case "3":
//                System.out.print("Entrez l'année (AAAA) : ");
//                int anneeSemaine = Integer.parseInt(scanner.nextLine());
//                System.out.print("Entrez le numéro de semaine (1-52) : ");
//                int semaine = Integer.parseInt(scanner.nextLine());
//
//                DateEvenement debutSemaine = new DateEvenement(LocalDateTime.now()
//                        .withYear(anneeSemaine)
//                        .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
//                        .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
//                        .withHour(0).withMinute(0));
//                DateEvenement finSemaine = new DateEvenement(debutSemaine.plusDays(7).minusSeconds(1));
//
//                afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine).getEvenements());
//                break;
//
//            case "4":
//                System.out.print("Entrez l'année (AAAA) : ");
//                int anneeJour = Integer.parseInt(scanner.nextLine());
//                System.out.print("Entrez le mois (1-12) : ");
//                int moisJour = Integer.parseInt(scanner.nextLine());
//                System.out.print("Entrez le jour (1-31) : ");
//                int jour = Integer.parseInt(scanner.nextLine());
//
//                DateEvenement debutJour = new DateEvenement(LocalDateTime.of(anneeJour, moisJour, jour, 0, 0));
//                DateEvenement finJour = new DateEvenement(debutJour.plusDays(1).minusSeconds(1));
//
//                afficherListe(calendar.eventsDansPeriode(debutJour, finJour).getEvenements());
//                break;
//        }

        return user;
    }

    public static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }
}
