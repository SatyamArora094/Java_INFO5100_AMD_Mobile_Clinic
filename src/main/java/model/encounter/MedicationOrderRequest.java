package model.encounter;

import model.patient.Patient;
import model.staff.Employee;

public class MedicationOrderRequest {
    String tabletName;
    int quantity;
    Patient p;
    Employee doc;

    public MedicationOrderRequest(String tabletName, int quantity, Patient p, Employee d) {
        this.tabletName = tabletName;
        this.quantity = quantity;
        this.p = p;
        this.doc = d;
    }

    public String getTabletName() {
        return tabletName;
    }

    public int getQuantity() {
        return quantity;
    }
}
