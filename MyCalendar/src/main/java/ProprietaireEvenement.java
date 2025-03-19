public class ProprietaireEvenement {

    private String proprietaire;

    public ProprietaireEvenement(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public String toString() {
        return proprietaire;
    }
}
