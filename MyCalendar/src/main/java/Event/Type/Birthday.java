package Event.Type;
import Event.*;
import Event.ValueObjectsEvent.AllEvent.DateEvent;
import Event.ValueObjectsEvent.AllEvent.DureeEvent;
import Event.ValueObjectsEvent.AllEvent.OwnerEvent;
import Event.ValueObjectsEvent.AllEvent.TitleEvent;
import Event.ValueObjectsEvent.Birthday.AgePerson;
import Event.ValueObjectsEvent.Birthday.NamePerson;

public class Birthday extends Event {

    private NamePerson person;
    private AgePerson age;

    public Birthday(TitleEvent titre, OwnerEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes, NamePerson person, AgePerson age) {
        super(titre, proprietaire, dateDebut, dureeMinutes);
        this.person = person;
        this.age = age;
    }

    public String getPerson() {
        return person.getName();
    }

    public int getAge() {
        return age.getAge();
    }

    @Override
    public String description() {
        return "Anniversaire : " + this.getTitle() +
                "\n     Pour : " + person + " qui fête ses " + age +
                "\n     Le : " + this.getDateDebut() +
                "\n     Durée : " + this.getDureeMinutes() +
                "\n     Propriétaire : " + this.getProprietaire();
    }

}
