package Event;

public class ParticipantsEvent {

    private String participants;

    public ParticipantsEvent(String participants) {
        this.participants = participants;
    }

    public void ajouterParticipant(String participant) {
        participants += ", " + participant;
    }

    @Override
    public String toString() {
        return participants;
    }
}
