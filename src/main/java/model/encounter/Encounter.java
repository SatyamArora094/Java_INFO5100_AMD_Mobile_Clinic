package model.encounter;

import java.util.Date;
import model.patient.Patient;

public class Encounter {
    Event event;
    Patient patient;
    Encounter followUp;
    ChiefComplaint chiefComplaint;
    EncounterHistory encounterhistory;
    Date visitDate;
    VitalSigns vitalSigns;

    public Encounter(EncounterHistory h, Date d, ChiefComplaint complaint, VitalSigns vs, Event event) {
        visitDate = d;
        encounterhistory = h;
        chiefComplaint = complaint;
        vitalSigns = vs;
        this.event = event;
    }

    public void addFllowUp(Encounter e) {
        followUp = e;
    }

    public Patient getPatient() {
        return encounterhistory.getPatient();
    }

    public Encounter getFollowUp() {
        return followUp;
    }

    public ChiefComplaint getChiefComplaint() {
        return chiefComplaint;
    }

    public EncounterHistory getEncounterhistory() {
        return encounterhistory;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void printAllinfo() {
        System.out.println("Event Details: ");
        this.printEvent();
        System.out.println("Visit Details: ");
        System.out.println("   --> Vist Date: " + this.getVisitDate());
        System.out.println("   --> Chief Complaint: " + this.getChiefComplaint().getComplaint());
        System.out.println("   --> Contagious_Flag: " + this.getPatient().getFlag());
        vitalSigns.printAllVitalSigns();
    }

    public int getTemperature() {
        return vitalSigns.getTemperature();
    }

    public Event getEvent() {
        return event;
    }

    public void printEvent() {
        event.printEvents();
    }
}
