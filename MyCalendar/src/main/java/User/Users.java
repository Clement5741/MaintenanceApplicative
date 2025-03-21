package User;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public void addUser(User u) {
        users.add(u);
    }

    public List<User> getUsers() {
        return users;
    }

}
