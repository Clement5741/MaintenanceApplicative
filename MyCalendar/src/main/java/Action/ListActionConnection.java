package Action;

import Action.GestionUser.ConnectionAction;
import Action.GestionUser.CreateAccountAction;
import User.Users;

public class ListActionConnection extends ListAction {

    public ListActionConnection(Users users) {
        super();
        addAction(1, new ConnectionAction(users));
        addAction(2, new CreateAccountAction(users));
    }

}
