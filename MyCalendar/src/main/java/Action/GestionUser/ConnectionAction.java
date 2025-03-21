package Action.GestionUser;

import Action.ActionInterface;
import User.GestionUser;
import User.User;
import User.Users;

public class ConnectionAction implements ActionInterface<User> {

    private Users users;

    public ConnectionAction(Users users) {
        this.users = users;
    }

    @Override
    public User execute() {
        return GestionUser.connection(users);
    }
}
