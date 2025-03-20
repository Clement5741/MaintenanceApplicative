package Evenement;

public class TitreEvenement {

    private String titre;

    public TitreEvenement(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    @Override
    public String toString() {
        return titre;
    }
}
