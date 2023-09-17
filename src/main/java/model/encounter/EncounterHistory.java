package model.encounter;

import java.util.ArrayList;
import java.util.Date;
import model.patient.Patient;

public class EncounterHistory {
    private Patient patient;
    private ArrayList<Encounter> encounterlist;
    private Encounter currentEncounter;

    public EncounterHistory(Patient p) {
        patient = p;
        encounterlist = new ArrayList<Encounter>();
    }

    public Patient getPatient() {
        return patient;
    }

    // public Encounter newEncounter(Date date, ChiefComplaint complaint, VitalSigns
    // vs, Event event){
    public Encounter newEncounter(Date date, ChiefComplaint complaint, VitalSigns vs, Event event) {
        Encounter encounter = new Encounter(this, date, complaint, vs, event);
        encounterlist.add(encounter);
        currentEncounter = encounter;
        return encounter;
    }

    public void printAllVitalSigns() {
        System.out.println("Please find the Patient History below");
        patient.getPatientinfo();
        int count = 1;
        for (Encounter e : encounterlist) {
            System.out.println("Visit number: " + count);
            e.printAllinfo();
            count += 1;
        }
    }

    public void printLatestVitalSigns() {
        System.out.println("Please find the Latest Patient Medical Record below");
        patient.getPatientinfo();
        encounterlist.get(encounterlist.size() - 1).printAllinfo();
    }

    public int getlatestTemperature() {
        return encounterlist.get(encounterlist.size() - 1).getTemperature();
    }

    public Encounter getCurreEncounter() {
        return currentEncounter;
    }

    public Event getEvent() {
        return currentEncounter.getEvent();
    }
}
