package model.person;

import java.util.Date;

public class Person {
    private String name;
    private Date dateofbirth;
    private PersonDirectory directory;

    public Person(String name, Date dob, PersonDirectory pd) {
        this.name = name;
        this.dateofbirth = dob;
        directory = pd;
    }

    public String getPersonName() {
        return name;
    }

    public Date getPersonDob() {
        return dateofbirth;
    }
}
