package model.patient;

import java.util.ArrayList;

import model.clinic.Clinic;
import model.person.Person;

public class PatientDirectory {
    private Clinic clinic;
    private ArrayList<Patient> patientlist;

    public PatientDirectory(Clinic c) {
        clinic = c;
        patientlist = new ArrayList<Patient>();
    }

    public Patient newPatientProfile(Person p) {
        Patient pp = new Patient(p, this);
        patientlist.add(pp);
        return pp;
    }

    public int getPatientCount() {
        return patientlist.size();
    }

    public Patient getPatientByIndex(int index) {
        return patientlist.get(index);
    }

    public Patient searchPatientByName(String name) {
        for (Patient p : patientlist) {
            if (p.getPatientName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Patient> getPatientlist() {
        return patientlist;
    }

}
