package model.location;

import java.util.ArrayList;
import java.util.Random;

import model.clinic.Clinic;

public class SiteCatalog {
    Clinic clinic;
    ArrayList<Site> sitelist;
    Location loc;

    public SiteCatalog(Location loc) {
        this.sitelist = new ArrayList<>();
        this.loc = loc;
    }

    public Site newSite(String siteName, Location loc) {
        Site s = new Site(siteName, loc, this);
        sitelist.add(s);
        return s;
    }

    public String getSiteName() {
        for (Site s : sitelist) {
            s.getSitename();
        }
        return null;
    }

    public Site getRandomSite() {
        Site site = sitelist.get(new Random().nextInt(sitelist.size()));
        return site;
    }

    public int getTotalFunding() {
        int count = 0;
        for (Site s : sitelist) {
            count += s.getSiteFunding();
        }
        return count;
    }
}
