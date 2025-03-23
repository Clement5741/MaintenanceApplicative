package Action.Event.ViewEvent;

import Action.ActionInterface;
import User.User;

public class BackEventAction implements ActionInterface<User> {

    @Override
    public User execute() {
        return null;
    }

    @Override
    public String toString() {
        return "Retour";
    }
}
