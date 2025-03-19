package Evenement;

public class FrequenceJoursEvenement {

    private int frequenceJours;

    public FrequenceJoursEvenement(int frequenceJours) {
        this.frequenceJours = frequenceJours;
    }

    public int getFrequenceJours() {
        return frequenceJours;
    }

    @Override
    public String toString() {
        return String.valueOf(frequenceJours);
    }
}
