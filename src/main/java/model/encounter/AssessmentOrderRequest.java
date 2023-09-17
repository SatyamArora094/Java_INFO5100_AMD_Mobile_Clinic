package model.encounter;

import model.patient.Patient;

public class AssessmentOrderRequest {
    String assessment;
    String category;
    Patient p;

    public AssessmentOrderRequest(String assessment, String cat, Patient p) {
        this.assessment = assessment;
        this.category = cat;
        this.p = p;
    }

    public String getAssessment() {
        return assessment;
    }

}
