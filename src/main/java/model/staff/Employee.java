package model.staff;

import model.person.Person;

public class Employee {
    Person person;
    String role;
    EmployeeDirectory directory;

    public Employee(Person person, String role, EmployeeDirectory ed) {
        this.person = person;
        this.role = role;
        directory = ed;
    }

    public Person getPerson() {
        return person;
    }

    public String getRole() {
        return role;
    }

}
