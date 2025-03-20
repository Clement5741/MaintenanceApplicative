package Action.GestionUser;

import Action.ActionInterface;
import User.*;

public class DeconnexionAction implements ActionInterface<User> {

    private User user;

    public DeconnexionAction(User user) {
        this.user = user;
    }

    @Override
    public User execute() {
        return GestionUser.deconnexion(user);
    }
}
