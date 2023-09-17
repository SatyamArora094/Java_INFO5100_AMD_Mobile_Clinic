package model.encounter;

import java.util.Random;

import model.patient.Patient;

public class ChiefComplaint {
    String[] complaints = { "COVID-19", "Influenza", "Ebola", "HIV/AIDS", "headache", "Fever", "Joint Pain" };
    String complaint;
    Patient patient;

    public ChiefComplaint(Patient patient) {
        this.complaint = complaints[new Random().nextInt(complaints.length)];
        this.patient = patient;
    }

    public String getComplaint() {
        return complaint;
    }

    public Patient getPatient() {
        return patient;
    }

}
