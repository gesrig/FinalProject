package com.example.gregoryesrig24.finalproject;

import java.io.Serializable;

/**
 * Created by gregoryesrig24 on 5/1/17.
 */

public class ReceiverUser implements Serializable {
    String Organization;
    String State;
    String City;
    String Street;
    int Zipcode;
    String PickUp;

    public ReceiverUser(String Org, String state, String city, String street, int zip, String pickup) {
        setOrganization(Org);
        setState(state);
        setCity(city);
        setStreet(street);
        setZipcode(zip);
        setPickUp(pickup);

    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

    public String getOrganization() {
        return this.Organization;
    }
    public void setState(String State) {
        this.State = State;
    }

    public String getState() {
        return this.State;
    }
    public void setCity(String City) {
        this.City = City;
    }

    public String getCity() {
        return this.City;
    }
    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getStreet() {
        return this.Street;
    }
    public void setZipcode(int Zipcode) {
        this.Zipcode = Zipcode;
    }
    public int getZipcode() {
        return this.Zipcode;
    }
    public void setPickUp(String PickUp) {
        this.PickUp = PickUp;
    }
    public String getPickUp() {
        return this.PickUp;
    }
}
