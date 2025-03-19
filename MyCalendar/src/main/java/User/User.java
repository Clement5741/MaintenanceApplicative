package User;

public class User {

    UserName nom;
    UserPassword motDePasse;

    public User(UserName nom, UserPassword motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom.getNom();
    }

    public String getMotDePasse() {
        return motDePasse.getMotDePasse();
    }
}
