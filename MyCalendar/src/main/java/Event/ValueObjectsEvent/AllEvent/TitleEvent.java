package Event.ValueObjectsEvent.AllEvent;

public class TitleEvent {

    private String titre;

    public TitleEvent(String titre) {
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
