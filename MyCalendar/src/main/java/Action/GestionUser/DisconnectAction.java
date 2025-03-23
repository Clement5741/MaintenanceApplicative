package Action.GestionUser;

import Action.ActionInterface;
import User.*;

public class DisconnectAction implements ActionInterface<User> {

    private User user;

    public DisconnectAction(User user) {
        this.user = user;
    }

    @Override
    public User execute() {
        return GestionUser.disconnect(user);
    }

    @Override
    public String toString() {
        return "Se déconnecter";
    }
}
