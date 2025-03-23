package Event.ValueObjectsEvent.Birthday;

public class AgePerson {
    private int age;

    public AgePerson(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return age + " ans";
    }
}
