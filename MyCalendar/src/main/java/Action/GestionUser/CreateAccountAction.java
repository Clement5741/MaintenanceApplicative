package Action.GestionUser;

import Action.ActionInterface;
import User.GestionUser;
import User.User;
import User.Users;

public class CreateAccountAction implements ActionInterface<User> {

    private Users users;

    public CreateAccountAction(Users users) {
        this.users = users;
    }

    @Override
    public User execute() {
        return GestionUser.createAccount(users);
    }

    @Override
    public String toString() {
        return "Créer un compte";
    }
}
