package model.location;

public class Location {
    String locationName;
    LocationList ll;
    SiteCatalog siteCatalog;

    public Location(String locationName, LocationList ll) {
        this.locationName = locationName;
        this.ll = ll;
        siteCatalog = new SiteCatalog(this);
    }

    public SiteCatalog getSiteCatalog() {
        return siteCatalog;
    }

    public String getLocationName() {
        return locationName;
    }

    public LocationList getLl() {
        return ll;
    }

    public Site getRandomSite() {
        return siteCatalog.getRandomSite();

    }

    public int getTotalFunding() {
        return siteCatalog.getTotalFunding();
    }

}
