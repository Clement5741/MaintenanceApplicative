package User;

public class User {

    UserName name;
    UserPassword password;

    public User(UserName name, UserPassword password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name.getName();
    }

    public String getPassword() {
        return password.getPassword();
    }
}
