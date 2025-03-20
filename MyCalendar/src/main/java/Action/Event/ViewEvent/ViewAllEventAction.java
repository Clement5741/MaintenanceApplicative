package Action.Event.ViewEvent;


import Action.ActionInterface;
import Calendar.CalendarManager;
import User.User;

public class ViewAllEventAction implements ActionInterface<User> {

    private CalendarManager calendar;

    public ViewAllEventAction(CalendarManager calendar) {
        this.calendar = calendar;
    }


    @Override
    public User execute() {
        calendar.afficherEvenements();
        return null;
    }
}
