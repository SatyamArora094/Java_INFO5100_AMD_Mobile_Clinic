package model.patient;

import java.util.ArrayList;
import java.util.Date;

import com.github.javafaker.Bool;

import model.encounter.AssessmentOrderRequest;
import model.encounter.ChiefComplaint;
import model.encounter.Diagnosis;
import model.encounter.Encounter;
import model.encounter.EncounterHistory;
import model.encounter.Event;
import model.encounter.MedicationOrderRequest;
import model.encounter.TreatmentOrderRequest;
import model.encounter.VitalSigns;
import model.person.Person;
import model.staff.Employee;

public class Patient {
    private PatientDirectory patients;
    private Person person;
    private VitalSigns vs;
    private EncounterHistory enocunterHistory;
    private ArrayList<ChiefComplaint> complaints;
    private Diagnosis d;
    private Boolean flag;

    public Patient(Person p, PatientDirectory pd) {
        person = p;
        patients = pd;
        enocunterHistory = new EncounterHistory(this);
        complaints = new ArrayList<ChiefComplaint>();
        this.flag = false;
    }

    public void getPatientinfo() {
        System.out.println("Patient Name: " + person.getPersonName());
        System.out.println("Patient Date of Birth: " + person.getPersonDob());
    }

    public void getPatientMedicalHistory() {
        enocunterHistory.printAllVitalSigns();
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void getPatientLatestMedicalHistory() {
        enocunterHistory.printLatestVitalSigns();
    }

    public void getPatientVisitDates() {
        System.out.println("Patient Name: " + person.getPersonName());
        System.out.println("Patient Date of Birth: " + person.getPersonDob());
    }

    public PatientDirectory getPatients() {
        return patients;
    }

    public EncounterHistory getHistory() {
        return enocunterHistory;
    }

    public void printEncounter() {

    }

    public ChiefComplaint newChiefComplaint() {
        ChiefComplaint c = new ChiefComplaint(this);
        complaints.add(c);
        return c;
    }

    public VitalSigns newVitalSign(Patient p) {
        VitalSigns newvitalsign = new VitalSigns(p);
        return newvitalsign;
    }

    public Encounter newEncounter(Date date, Event event) {
        ChiefComplaint c = this.newChiefComplaint();
        VitalSigns vs = this.newVitalSign(this);
        Encounter e = enocunterHistory.newEncounter(date, c, vs, event);
        return e;
    }

    public String getComplaint() {
        // return complaints.getComplaint();
        if (complaints.size() > 0) {
            return complaints.get(complaints.size() - 1).getComplaint();
        }
        return "N/A";
    }

    public int getlatestTemperature() {
        return enocunterHistory.getlatestTemperature();
    }

    public String getPatientName() {
        return person.getPersonName();
    }

    public Encounter getCurrentEncounter() {
        return enocunterHistory.getCurreEncounter();
    }

    public Diagnosis newDiagnosis(String a, String cat, Boolean contagious) {
        AssessmentOrderRequest assessment = new AssessmentOrderRequest(a, cat, this);
        Diagnosis d = new Diagnosis(assessment, this, contagious);
        return d;
    }

}
