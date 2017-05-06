package com.example.gregoryesrig24.finalproject;

import java.io.Serializable;

/**
 * Created by gregoryesrig24 on 5/1/17.
 */

public class GiverUser implements Serializable{
    String UserName;
    String State;
    String City;
    String Street;
    int Zipcode;
    int Miles;

    public GiverUser(String UN, String state, String city, String street, int zip, int miles) {
        setUserName(UN);
        setState(state);
        setCity(city);
        setStreet(street);
        setZipcode(zip);
        setMiles(miles);

    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {
        return this.UserName;
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
    public void setMiles(int Miles) {
        this.Miles = Miles;
    }
    public int getMiles() {
        return this.Miles;
    }
    public void setZipcode(int Zipcode) {
        this.Zipcode = Zipcode;
    }
    public int getZipcode() { return this.Zipcode; }

}
