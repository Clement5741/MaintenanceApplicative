package Action.Event;

import Action.Event.ViewEvent.*;
import Action.ListAction;
import Calendar.CalendarManager;

public class ListActionViewEvent extends ListAction {

    public ListActionViewEvent(CalendarManager calendar) {
        super();
        actions.put(1, new ViewAllEventAction(calendar));
        actions.put(2, new ViewMonthEventAction(calendar));
        actions.put(3, new ViewWeekEventAction(calendar));
        actions.put(4, new ViewDayEventAction(calendar));
        actions.put(5, new ViewEventInPeriodAction(calendar));
        actions.put(6, new BackEventAction());
    }

    @Override
    public void afficherMenu() {
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        super.afficherMenu();
        System.out.println("======================================");
    }
}
