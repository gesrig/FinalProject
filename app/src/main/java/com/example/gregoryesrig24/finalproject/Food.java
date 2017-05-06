package com.example.gregoryesrig24.finalproject;

import java.io.Serializable;

/**
 * Created by gregoryesrig24 on 5/6/17.
 */

public class Food implements Serializable {
    String username;
    int Ham;
    int Turkey;
    int Cheese;
    int Beans;
    int Rice;

    public Food() {
        Ham = 0;
        Turkey = 0;
        Cheese = 0;
        Beans = 0;
        Rice = 0;
        username = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHam() {
        return Ham;
    }

    public void setHam(int ham) {
        Ham = ham;
    }

    public int getTurkey() {
        return Turkey;
    }

    public void setTurkey(int turkey) {
        Turkey = turkey;
    }

    public int getCheese() {
        return Cheese;
    }

    public void setCheese(int cheese) {
        Cheese = cheese;
    }

    public int getBeans() {
        return Beans;
    }

    public void setBeans(int beans) {
        Beans = beans;
    }

    public int getRice() {
        return Rice;
    }

    public void setRice(int rice) {
        Rice = rice;
    }


}
