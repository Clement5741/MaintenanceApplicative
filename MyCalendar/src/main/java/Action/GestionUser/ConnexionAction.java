package Action.GestionUser;

import Action.ActionInterface;
import User.GestionUser;
import User.User;
import User.Users;

public class ConnexionAction implements ActionInterface<User> {

    private Users users;

    public ConnexionAction(Users users) {
        this.users = users;
    }

    @Override
    public User execute() {
        return GestionUser.connexion(users);
    }
}
