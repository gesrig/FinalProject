package com.example.gregoryesrig24.finalproject;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 * Created by gregoryesrig24 on 5/6/17.
 */

public class Clothing implements Serializable {
    int Shirt;
    int Shorts;
    int Pants;
    int Coats;
    int Socks;
    int Shoes;
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getShirt() {
        return Shirt;
    }

    public void setShirt(int shirt) {
        Shirt = shirt;
    }

    public int getShorts() {
        return Shorts;
    }

    public void setShorts(int shorts) {
        Shorts = shorts;
    }

    public int getPants() {
        return Pants;
    }

    public void setPants(int pants) {
        Pants = pants;
    }

    public int getCoats() {
        return Coats;
    }

    public void setCoats(int coats) {
        Coats = coats;
    }

    public int getSocks() {
        return Socks;
    }

    public void setSocks(int socks) {
        Socks = socks;
    }

    public int getShoes() {
        return Shoes;
    }

    public void setShoes(int shoes) {
        Shoes = shoes;
    }
}
