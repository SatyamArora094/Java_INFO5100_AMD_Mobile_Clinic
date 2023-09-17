package model.encounter;

import model.patient.Patient;
import model.staff.Employee;

public class Diagnosis {
    AssessmentOrderRequest assessment;
    TreatmentOrderRequest treatment;
    Patient patient;
    Boolean contagious = false;

    public Diagnosis(AssessmentOrderRequest assessment, Patient p, Boolean c) {
        this.assessment = assessment;
        patient = p;
        contagious = c;
    }

    public String getAssessment() {
        return assessment.getAssessment();
    }

    public String getTreatment() {
        return treatment.getTreatment();
    }
}
