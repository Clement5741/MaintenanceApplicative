package Event;

public class OwnerEvent {

    private String proprietaire;

    public OwnerEvent(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public String toString() {
        return proprietaire;
    }
}
