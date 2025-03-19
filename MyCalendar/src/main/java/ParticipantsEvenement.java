public class ParticipantsEvenement {

    private String participants;

    public ParticipantsEvenement(String participants) {
        this.participants = participants;
    }

    public void ajouterParticipant(String participant) {
        participants += ", " + participant;
    }
}
