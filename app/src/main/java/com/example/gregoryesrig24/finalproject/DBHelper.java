package com.example.gregoryesrig24.finalproject;

/**
 * Created by gregoryesrig24 on 4/28/17.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper{

    public SQLiteDatabase db;
    public static String DATABASE_NAME = "DonoMatch.db";
    public static int DATABASE_VERSION = 1;
    public static String TABLE_RECEIVE = "ReceivingTable";
    public static String COL_r_ORG = "organization";
    public static String COL_r_STATE = "stateR";
    public static String COL_r_CITY = "cityR";
    public static String COL_r_STREET = "streetR";
    public static String COL_r_ZIP = "zipcode";
    public static String COL_r_PICKUP = "no";


    public static String TABLE_GIVE = "GivingTable";
    public static String COL_g_USERNAME = "usernameG";
    public static String COL_g_STATE = "stateG";
    public static String COL_g_CITY = "cityG";
    public static String COL_g_STREET = "streetG";
    public static String COL_g_ZIP = "zipcode";
    public static String COL_g_MILES = "miles";

    public static String TABLE_TOYS = "ToyTable";
    public static String COL_t_USERNAME = "User";
    public static String COL_ELECTRONICS = "electronics";
    public static String COL_VIDEOGAMES = "VideoGames";
    public static String COL_LEGOS = "Legos";
    public static String COL_BLOCKS = "Blocks";
    public static String COL_BOOKS = "Books";

    public static String TABLE_FOOD = "FoodTable";
    public static String COL_f_USERNAME = "User";
    public static String COL_HAM = "ham";
    public static String COL_TURKEY = "turkey";
    public static String COL_CHEESE = "cheese";
    public static String COL_BEANS = "beans";
    public static String COL_RICE = "rice";

    public static String TABLE_CLOTHING = "ClothingTable";
    public static String COL_c_USERNAME = "User";
    public static String COL_SHIRT = "shirt";
    public static String COL_SHORTS = "shorts";
    public static String COL_PANTS = "pants";
    public static String COL_COATS = "coats";
    public static String COL_SOCKS = "socks";
    public static String COL_SHOES = "shoes";




    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // THIS IS WRONG. PICKUP IS A BOOL. NEED TO CHANGE THE EXEC SQL FUCTION ON IT
        db.execSQL("CREATE TABLE " + TABLE_RECEIVE + " ( " + COL_r_ORG + " TEXT," + COL_r_STATE +
                " TEXT," + COL_r_CITY + " TEXT," + COL_r_STREET + " TEXT,"
                + COL_r_ZIP + " INTEGER," + COL_r_PICKUP + " TEXT )");
        // AGAIN WRONG. MILES ISN'T A STRING IT IS A BOOL
        db.execSQL("CREATE TABLE " + TABLE_GIVE + " ( " + COL_g_USERNAME + " TEXT," +
                COL_r_STATE + " TEXT," + COL_g_CITY + " TEXT," + COL_r_STREET + " TEXT," + COL_g_ZIP + " INTEGER,"
                + COL_g_MILES + " INTEGER )");

        db.execSQL("CREATE TABLE " + TABLE_TOYS + " ( " + COL_t_USERNAME + " TEXT," +
                COL_ELECTRONICS + " INTEGER," + COL_VIDEOGAMES + " INTEGER," + COL_LEGOS + " INTEGER," + COL_BLOCKS + " INTEGER,"
                + COL_BOOKS + " INTEGER )");
        db.execSQL("CREATE TABLE " + TABLE_FOOD + " ( " + COL_f_USERNAME + " TEXT," +
                COL_HAM + " INTEGER," + COL_TURKEY + " INTEGER," + COL_CHEESE + " INTEGER," + COL_BEANS + " INTEGER,"
                + COL_RICE + " INTEGER )");
        db.execSQL("CREATE TABLE " + TABLE_CLOTHING + " ( " + COL_c_USERNAME + " TEXT," +
                COL_SHIRT + " INTEGER," + COL_SHORTS + " INTEGER," + COL_PANTS + " INTEGER," + COL_COATS + " INTEGER,"
                + COL_SOCKS + " INTEGER," + COL_SHOES + " INTEGER )");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists " + TABLE_RECEIVE );
        db.execSQL("DROP TABLE if exists " + TABLE_GIVE );
        db.execSQL("DROP TABLE if exists " + TABLE_TOYS );
        db.execSQL("DROP TABLE if exists " + TABLE_FOOD );
        db.execSQL("DROP TABLE if exists " + TABLE_CLOTHING );

        onCreate(db);
    }


    public void InsertUserReceiveInfo(ReceiverUser RecUser) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_r_ORG, RecUser.getOrganization());
        contentValues.put(COL_r_STATE, RecUser.getState());
        contentValues.put(COL_r_CITY, RecUser.getCity());
        contentValues.put(COL_r_STREET, RecUser.getStreet());
        contentValues.put(COL_r_ZIP, RecUser.getZipcode());
        contentValues.put(COL_r_PICKUP, RecUser.getPickUp());
        long ret = db.insert(TABLE_RECEIVE, null, contentValues );


        db.close();
    }

    public void InsertUserGiveInfo(GiverUser GivUser) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_g_USERNAME, GivUser.getUserName());
        contentValues.put(COL_g_STATE, GivUser.getState());
        contentValues.put(COL_g_CITY, GivUser.getCity());
        contentValues.put(COL_g_STREET, GivUser.getStreet());
        contentValues.put(COL_g_ZIP, GivUser.getZipcode());
        contentValues.put(COL_g_MILES, GivUser.getMiles());
        long ret = db.insert(TABLE_GIVE, null, contentValues );

        db.close();

    }

    public void InsertFood(Food food) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_f_USERNAME, food.getUsername());
        contentValues.put(COL_HAM, food.getHam());
        contentValues.put(COL_TURKEY, food.getTurkey());
        contentValues.put(COL_CHEESE, food.getCheese());
        contentValues.put(COL_BEANS, food.getBeans());
        contentValues.put(COL_RICE, food.getRice());
        long ret = db.insert(TABLE_FOOD, null, contentValues );

        db.close();

    }

    public void InsertToys(Toys toy) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_t_USERNAME, toy.getUsername());
        contentValues.put(COL_ELECTRONICS, toy.getElectronics());
        contentValues.put(COL_VIDEOGAMES, toy.getVideoGames());
        contentValues.put(COL_LEGOS, toy.getLegos());
        contentValues.put(COL_BLOCKS, toy.getBlocks());
        contentValues.put(COL_BOOKS, toy.getBooks());
        long ret = db.insert(TABLE_TOYS, null, contentValues );

        db.close();

    }

    public void InsertClothing(Clothing clothes) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_c_USERNAME, clothes.getUsername());
        contentValues.put(COL_SHIRT, clothes.getShirt());
        contentValues.put(COL_SHORTS, clothes.getShorts());
        contentValues.put(COL_PANTS, clothes.getPants());
        contentValues.put(COL_COATS, clothes.getCoats());
        contentValues.put(COL_SOCKS, clothes.getSocks());
        contentValues.put(COL_SHOES, clothes.getShoes());
        long ret = db.insert(TABLE_CLOTHING, null, contentValues );

        db.close();

    }








}
