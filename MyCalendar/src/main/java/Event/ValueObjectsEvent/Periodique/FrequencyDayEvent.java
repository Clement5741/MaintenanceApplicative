package Event.ValueObjectsEvent.Periodique;

public class FrequencyDayEvent {

    private int frequenceJours;

    public FrequencyDayEvent(int frequenceJours) {
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
