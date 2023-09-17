package model.location;

import com.github.javafaker.Faker;
import java.util.concurrent.TimeUnit;
import model.encounter.Event;

public class Site {
    SiteCatalog sitelist;
    String sitename;
    Location location;
    Event event;
    Faker magicBox = new Faker();

    public Site(String sitename, Location location, SiteCatalog sitelist) {
        this.sitename = sitename;
        this.location = location;
        this.sitelist = sitelist;
        event = new Event(this, magicBox.date().future(1, TimeUnit.DAYS), magicBox.medical().hospitalName());
    }

    public void printSiteDetails() {
        System.out.println("--> Location name: " + location.getLocationName());
        System.out.println("--> Site name: " + sitename);
    }

    public SiteCatalog getSitelist() {
        return sitelist;
    }

    public void setSitelist(SiteCatalog sitelist) {
        this.sitelist = sitelist;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Event getEvent() {
        return event;
    }

    public int getSiteFunding() {
        return event.getFunding();
    }
}
