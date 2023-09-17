package model.location;

import java.util.ArrayList;
import java.util.Random;

import model.clinic.Clinic;

public class LocationList {
    Clinic clinic;
    ArrayList<Location> locationlist;
    SiteCatalog siteCatalog;
    Random r = new Random();

    public LocationList(Clinic c) {
        clinic = c;
        locationlist = new ArrayList<>();
    }

    public Location newLocation(String name) {
        Location l = new Location(name, this);
        locationlist.add(l);
        return l;
    }

    public Location getLocation(String locname) {
        for (Location l : locationlist) {
            if (locname.equals(l.getLocationName())) {
                return l;
            }
        }
        return null;
    }

    public Site getRandomSite() {
        Location loc = locationlist.get(r.nextInt(locationlist.size()));
        return loc.getRandomSite();
    }

    public int getTotalFunding() {
        int count = 0;
        for (Location l : locationlist) {
            count += l.getTotalFunding();
        }
        return count;
    }

}
