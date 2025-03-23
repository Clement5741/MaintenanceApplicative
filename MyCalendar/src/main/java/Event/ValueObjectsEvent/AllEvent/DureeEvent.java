package Event.ValueObjectsEvent.AllEvent;

public class DureeEvent {

    private int minutes;

    public DureeEvent(int minutes) {
        this.minutes = minutes;
    }

    public int getDuree() {
        return minutes;
    }

    @Override
    public String toString() {
        return minutes + " minutes";
    }
}
