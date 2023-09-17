package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.github.javafaker.Faker;

import model.clinic.Clinic;
import model.clinic.DataLoader;
import model.encounter.Event;
import model.location.Site;
import model.patient.Patient;

/**
 * Hello world!
 *
 */
public class MobileClinicMain {
    public static void main(String[] args) {
        // Northeastern Health and Counceling Services
        Clinic mhc = new Clinic("Hospital on-Wheels (Mobile Health Center)");
        DataLoader loader = new DataLoader(mhc);

        // Populate Patient, Employee and Encounter data
        loader.populateClinic(6, 5, 3);

        // Initializing Faker and Random object
        Faker magicBox = new Faker();
        Random rand = new Random();

        System.out.println("---------------------------- Welcome to " + mhc.getName() + "----------------------------");

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("Is there any new Patients here? (y or n)");

            String choice1 = scanner.nextLine();
            switch (choice1) {
                case "n":
                    exit = true;
                    break;
                case "y":
                    System.out.println("Please enter Patient Name:");
                    String name = scanner.nextLine();
                    if (mhc.searchPatientByName(name) != null) {
                        System.out.println("Patient already exists in Database");
                    } else {
                        mhc.newPatientProfile(name, magicBox.date().birthday());
                    }
                    break;
                default:
                    System.out.println("No new Patients added");
                    exit = true;
                    break;
            }
        }

        ArrayList<Patient> contagiousPatients = new ArrayList<>();
        List<String> contagiousDiseases = Arrays.asList("COVID-19", "Influenza", "Ebola", "HIV/AIDS");
        ArrayList<Patient> patients = mhc.getPatientDirectory().getPatientlist();

        for (Patient p : patients) {
            Site site = mhc.getRandomSite();
            Event event = site.getEvent();
            Date date = event.getEventDate();
            p.newEncounter(date, event);
            if (contagiousDiseases.contains(p.getComplaint())) {
                System.out.println("--------------------------------------------------------------");
                p.newDiagnosis(p.getComplaint(), "Infectious", true);
                contagiousPatients.add(p);
                p.getPatientinfo();
                p.setFlag(true);
                System.out.println("--> Disease name: " + p.getComplaint());
                System.out.println("--> Contagious_Flag: " + p.getFlag());
                System.out.println(
                        "--> You have a Infectious Disease. Please quarantine yourself and take necessary precaution");
                System.out.println(
                        "Your Flag status has been set to true. Please come for a check-up after 15 days and your status will be reset once your disease is cured.");
            } else {
                p.newDiagnosis(p.getComplaint(), "General", false);
            }
        }

        // Show List of Patients, the times they showed up, and the locations there they
        // showed up for checkups.
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nTotal number of Patients came for check-up: " + patients.size());
        System.out.println(
                "The List of Patients, the times they showed up, and the locations where they showed up for checkups: \n");
        for (Patient p : patients) {
            p.getPatientinfo();
            p.getCurrentEncounter().printAllinfo();
            System.out.println("--------------------------------------------------------------");
        }

        ArrayList<String> events = new ArrayList<>();
        // List of Patients who show symptoms for contagious disease
        System.out.println(
                "\nTotal number of Patients who show symptoms for contagious disease are: " + contagiousPatients.size());
        System.out.println("\nThe List of Patients who show symptoms for contagious disease are: ");
        for (Patient p : contagiousPatients) {
            events.add(p.getCurrentEncounter().getEvent().getEventName());
            System.out.println(p.getPatientName() + " - " + p.getComplaint());
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("The Total Funding for all the events are: " + mhc.getTotalFunding());

        // Feature that could help the Doctors and Nurses
        System.out.println("--------------------------------------------------------------");
        System.out.println(
                "The list below contains a list of occurrences as well as the number of contiguous patients identified in each event."
                        + "\nOrganizing additional events in high-infected areas could help reduce the spread of diseases.\n");
        Set<String> set = new HashSet<String>(events);
        for (String s : set) {
            System.out.println(s + ": " + Collections.frequency(events, s));

        }
    }
}
