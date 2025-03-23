package Event.ValueObjectsEvent.Reunion;

public class PlaceEvent {
    private String lieu;

    public PlaceEvent(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        return lieu;
    }
}
