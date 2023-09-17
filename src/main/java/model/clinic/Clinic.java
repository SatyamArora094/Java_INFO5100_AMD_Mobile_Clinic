package model.clinic;

import java.util.Date;
import model.patient.PatientDirectory;
import model.encounter.Event;
import model.location.Location;
import model.location.LocationList;
import model.location.Site;
import model.location.SiteCatalog;
import model.patient.Patient;
import model.person.Person;
import model.person.PersonDirectory;
import model.staff.Employee;
import model.staff.EmployeeDirectory;

public class Clinic {
    private LocationList locationlist;
    private String name;
    private PatientDirectory patients;
    private PersonDirectory persons;
    private EmployeeDirectory employees;

    public Clinic(String name) {
        this.name = name;
        patients = new PatientDirectory(this);
        persons = new PersonDirectory(this);
        employees = new EmployeeDirectory(this);
        locationlist = new LocationList(this);
    }

    public Patient newPatientProfile(String name, Date dob) {
        Person person = persons.newPerson(name, dob);
        Patient patient = patients.newPatientProfile(person);
        return patient;
    }

    public Patient searchPatientByName(String name) {
        return patients.searchPatientByName(name);
    }

    public Employee newEmployee(String n, Date dob, String role) {
        Person person = persons.newPerson(n, dob);
        Employee ep = employees.newEmployee(person, role);
        return ep;
    }

    public Site getRandomSite() {
        return locationlist.getRandomSite();
    }

    public LocationList getLocationList() {
        return locationlist;
    }

    public String getName() {
        return name;
    }

    public PatientDirectory getPatientDirectory() {
        return patients;
    }

    public PersonDirectory getPersonDirectory() {
        return persons;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employees;
    }

    public int getPatientCount() {
        return patients.getPatientCount();
    }

    public int getTotalFunding() {
        return locationlist.getTotalFunding();
    }
}
