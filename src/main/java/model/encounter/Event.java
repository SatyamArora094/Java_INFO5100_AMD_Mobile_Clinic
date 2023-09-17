package model.encounter;

import java.util.Date;

import com.github.javafaker.Faker;

import model.location.Site;

public class Event {
    Site site;
    Date eventDate;
    String eventName;
    int funding;
    Faker magicbox = new Faker();

    public Event(Site site, Date eventDate, String eventName) {
        this.site = site;
        this.eventDate = eventDate;
        this.eventName = eventName;
        funding = magicbox.number().numberBetween(50000, 150000);
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void printEvents() {
        site.printSiteDetails();
        System.out.println("--> Event Date: " + getEventDate());
        System.out.println("--> Event Name: " + getEventName());
    }

    public int getFunding() {
        return funding;
    }

}
