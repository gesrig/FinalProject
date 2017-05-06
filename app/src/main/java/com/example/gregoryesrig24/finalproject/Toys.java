package com.example.gregoryesrig24.finalproject;

import java.io.Serializable;

/**
 * Created by gregoryesrig24 on 5/1/17.
 */

public class Toys implements Serializable{
    int Electronics;
    int VideoGames;
    int Legos;
    int Blocks;
    int Books;
    String username;

    public Toys() {
        Electronics = 0;
        VideoGames = 0;
        Legos = 0;
        Blocks = 0;
        Books = 0;
        username = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setElectronics(int Electronics) {
        this.Electronics = Electronics;
    }

    public int getElectronics() {
        return this.Electronics;
    }
    public void setVideoGames(int VideoGames) {
        this.VideoGames = VideoGames;
    }

    public int getVideoGames() {
        return this.VideoGames;
    }
    public void setLegos(int Legos) {
        this.Legos = Legos;
    }

    public int getLegos() {
        return this.Legos;
    }
    public void setBooks(int Books) {
        this.Books = Books;
    }

    public int getBooks() {
        return this.Books;
    }
    public void setBlocks(int Blocks) {
        this.Blocks = Blocks;
    }
    public int getBlocks() {
        return this.Blocks;
    }


}
