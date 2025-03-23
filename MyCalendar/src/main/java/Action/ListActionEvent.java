package Action;

import Action.Event.AddPeriodiqueAction;
import Action.Event.AddRDVAction;
import Action.Event.AddReunionAction;
import Action.Event.ViewEventAction;
import Action.GestionUser.DisconnectAction;
import Calendar.CalendarManager;
import User.User;

public class ListActionEvent extends ListAction {

    public ListActionEvent(User user, CalendarManager calendar) {
        super();
        addAction(1, new ViewEventAction(user, calendar));
        addAction(2, new AddRDVAction(user, calendar));
        addAction(3, new AddReunionAction(user, calendar));
        addAction(4, new AddPeriodiqueAction(user, calendar));
        addAction(5, new DisconnectAction(user));
    }

    @Override
    public void afficherMenu() {
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        super.afficherMenu();
        System.out.println("======================================");
    }
}
