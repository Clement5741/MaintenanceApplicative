package Action;

import User.User;

public class DefaultAction implements ActionInterface<User> {

    private User user;

    public DefaultAction(User user) {
        this.user = user;
    }

    @Override
    public User execute() {
        System.out.println("Option non valide.");
        return user;
    }

    @Override
    public String toString() {
        return "Option non valide.";
    }
}
