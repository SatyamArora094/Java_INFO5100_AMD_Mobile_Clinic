package model.encounter;

import model.patient.Patient;
import model.staff.Employee;

public class TreatmentOrderRequest {
    String treatment;
    Patient p;
    Employee d;

    public TreatmentOrderRequest(String treatment, Patient p, Employee d) {
        this.treatment = treatment;
        this.p = p;
        this.d = d;
    }

    public String getTreatment() {
        return treatment;
    }

}
