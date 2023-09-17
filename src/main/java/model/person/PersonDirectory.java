package model.person;

import java.util.ArrayList;
import java.util.Date;

import model.clinic.Clinic;

public class PersonDirectory {
    private ArrayList<Person> personlist;
    private Clinic clinic;

    public PersonDirectory(Clinic c) {
        personlist = new ArrayList<Person>();
        clinic = c;
    }

    public Person newPerson(String name, Date dob) {
        Person p = new Person(name, dob, this);
        personlist.add(p);
        return p;
    }

    public ArrayList<Person> getPersonlist() {
        return personlist;
    }

}
