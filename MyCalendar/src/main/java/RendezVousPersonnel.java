public class RendezVousPersonnel extends Event {


    public RendezVousPersonnel(TitreEvenement titre, ProprietaireEvenement proprietaire, DateEvenement date, DureeEvenement duree) {
        super(titre, proprietaire, date, duree);
    }

    @Override
    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }

}
