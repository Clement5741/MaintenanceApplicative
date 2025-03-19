package Evenement;

public class LieuEvenement {
    private String lieu;

    public LieuEvenement(String lieu) {
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
