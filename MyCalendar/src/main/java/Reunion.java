public class Reunion extends Event {

    private LieuEvenement lieu;

    private ParticipantsEvenement participants;

    public Reunion(TitreEvenement title, ProprietaireEvenement proprietaire, DateEvenement dateDebut, DureeEvenement dureeMinutes, LieuEvenement lieu, ParticipantsEvenement participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + title + " à " + lieu + " le " + dateDebut.toString();
    }


}
