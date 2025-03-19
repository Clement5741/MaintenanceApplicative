public class DureeEvenement {

    private int minutes;

    public DureeEvenement(int minutes) {
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
