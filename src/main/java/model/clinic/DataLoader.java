package model.clinic;

import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;
import java.util.concurrent.TimeUnit;

import model.encounter.Event;
import model.location.Location;
import model.location.LocationList;
import model.location.Site;
import model.location.SiteCatalog;
import model.patient.Patient;

public class DataLoader {
    private Faker magicBox;
    private Clinic clinic;
    private Random r;

    public DataLoader(Clinic c) {
        this.clinic = c;
        magicBox = new Faker();
        r = new Random();
    }

    public void populateClinic(int employeeCount, int patientCount, int randomPatientNumber) {
        populateSites();
        populateEmployeeDirectory(employeeCount);
        populatePatientDirectory(patientCount);
        populateEncounter(randomPatientNumber);
    }

    public void populateEmployeeDirectory(int count) {
        String[] arr = { "Professor", "Student" };
        for (int i = 0; i < count; i++) {
            clinic.newEmployee(magicBox.name().fullName(), magicBox.date().birthday(), arr[r.nextInt(arr.length)]);
        }
    }

    public void populatePatientDirectory(int count) {
        for (int i = 0; i < count; i++) {
            clinic.newPatientProfile(magicBox.name().fullName(), magicBox.date().birthday());
        }
    }

    public void populateEncounter(int count) {
        int patientCount = clinic.getPatientCount();
        for (int i = 0; i < count; i++) {
            Date date = magicBox.date().future(2, TimeUnit.DAYS);
            Site site = clinic.getRandomSite();
            Event event = site.getEvent();
            int randpick = r.nextInt(patientCount);
            Patient p = clinic.getPatientDirectory().getPatientByIndex(randpick);
            p.newEncounter(date, event);
        }
    }

    public void populateSites() {
        String[] loclist = { "San Jose", "San Francisco", "Milpitas", "Danville" };
        String[] sitelist = { "Downtown", "Race Street", "Golden Gate", "Point Reyes", "Great Mall", "Abel Strees",
                "Alamo Oaks", "San Ramon" };
        int j = 0, limit = 2;
        for (int i = 0; i < 4; i++) {
            LocationList ll = clinic.getLocationList();
            Location loc = ll.newLocation(loclist[i]);
            for (; j < limit; j++) {
                SiteCatalog sc = loc.getSiteCatalog();
                sc.newSite(sitelist[j], loc);
            }
            limit += 2;
        }
    }

}
