package model.staff;

import java.util.ArrayList;

import model.clinic.Clinic;
import model.person.Person;

public class EmployeeDirectory {
    Clinic clinic;
    ArrayList<Employee> employeelist;

    public EmployeeDirectory(Clinic c) {
        clinic = c;
        employeelist = new ArrayList<Employee>();
    }

    public Employee newEmployee(Person p, String role) {
        Employee ep = new Employee(p, role, this);
        employeelist.add(ep);
        return ep;
    }

    public ArrayList<Employee> getEmployeelist() {
        return employeelist;
    }

}
