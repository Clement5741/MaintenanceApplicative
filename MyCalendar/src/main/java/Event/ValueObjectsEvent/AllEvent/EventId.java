package Event.ValueObjectsEvent.AllEvent;

public class EventId {

    private String id;

    public EventId() {
        this.id = java.util.UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

}
