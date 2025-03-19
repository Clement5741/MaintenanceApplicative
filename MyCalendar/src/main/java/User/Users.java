package User;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> utilisateurs;

    public Users() {
        this.utilisateurs = new ArrayList<>();
    }

    public void ajouterUtilisateur(User u) {
        utilisateurs.add(u);
    }

    public int NombreUtilisateurs() {
        return utilisateurs.size();
    }

    public List<User> getUtilisateurs() {
        return utilisateurs;
    }

}
