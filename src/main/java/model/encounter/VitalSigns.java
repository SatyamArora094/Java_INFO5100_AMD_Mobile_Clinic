package model.encounter;

import java.util.Random;

import model.patient.Patient;

public class VitalSigns {
    Patient patient;
    int respRate;
    int heartRate;
    int bp;
    double weightKG;
    int temp;

    Random rand = new Random();

    public VitalSigns(Patient p) {
        this.patient = p;
        this.respRate = rand.nextInt(8) + 12;
        this.heartRate = rand.nextInt(30) + 70;
        this.bp = rand.nextInt(40) + 80;
        this.weightKG = rand.nextInt(42) + 42;
        this.temp = rand.nextInt(6) + 98;
    }

    public int getTemperature() {
        return temp;
    }

    public int getRespRate() {
        return respRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getBp() {
        return bp;
    }

    public double getWeightKG() {
        return weightKG;
    }

    public void printAllVitalSigns() {
        System.out.println("   --> Respiration Rate: " + getRespRate());
        System.out.println("   --> Heart Rate: " + getHeartRate());
        System.out.println("   --> Blood Pressure: " + getBp());
        System.out.println("   --> Weight: " + getWeightKG());
        System.out.println("   --> Temperature: " + getTemperature());
    }

}
