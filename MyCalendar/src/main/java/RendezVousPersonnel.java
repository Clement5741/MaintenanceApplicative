public class RendezVousPersonnel extends Event {


    public RendezVousPersonnel(DateEvenement date, ProprietaireEvenement proprietaire, DureeEvenement duree, TitreEvenement titre) {
        super(titre, proprietaire, date, duree);
    }

    @Override
    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }

}
