package com.example.gregoryesrig24.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.gregoryesrig24.finalproject.R.id.newItem;
import static com.example.gregoryesrig24.finalproject.R.id.toolbar;

/**
 * Created by michaelpenny on 4/11/17.
 */

public class SelectionActivity extends AppCompatActivity {
    Toys ToyItem = new Toys();
    Food FoodItem = new Food();
    Clothing ClothingItem = new Clothing();
    DBHelper dbHelper;
    String UserName = "";



    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private Button matchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHelper = new DBHelper(getApplicationContext());
        dbHelper.onUpgrade(dbHelper.getWritableDatabase(), 1, 2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        matchBtn = (Button) findViewById(R.id.matchButton);


        savedInstanceState = getIntent().getExtras();
        String activity = getIntent().getStringExtra("Activity");
        if (activity.equals("GiveProfile")) {
            GiverUser user = (GiverUser) savedInstanceState.getSerializable("GiveUserProfile");
            dbHelper.InsertUserGiveInfo(user);
            UserName = user.getUserName();
            ToyItem.setUsername(UserName);
            FoodItem.setUsername(UserName);
            ClothingItem.setUsername(UserName);
            matchBtn.setText("READY TO MATCH " + UserName + "?");
        }

        else if (activity.equals("Food")) {
            Food fitem = (Food) savedInstanceState.getSerializable("FoodActivity");
            matchBtn.setText("READY TO MATCH " + fitem.getUsername() + "?");
            FoodItem.setUsername(fitem.getUsername());
            ToyItem.setUsername(fitem.getUsername());
            ClothingItem.setUsername(fitem.getUsername());
            FoodItem.setHam(fitem.getHam());
            FoodItem.setTurkey(fitem.getTurkey());
            FoodItem.setCheese(fitem.getCheese());
            FoodItem.setBeans(fitem.getBeans());
            FoodItem.setRice(fitem.getRice());
        }
        else if (activity.equals("Clothes")) {
            Clothing citem = (Clothing) savedInstanceState.getSerializable("ClothingActivity");
            matchBtn.setText("READY TO MATCH " + citem.getUsername() + "?");
            FoodItem.setUsername(citem.getUsername());
            ToyItem.setUsername(citem.getUsername());
            ClothingItem.setUsername(citem.getUsername());
            ClothingItem.setShirt(citem.getShirt());
            ClothingItem.setShoes(citem.getShoes());
            ClothingItem.setCoats(citem.getCoats());
            ClothingItem.setPants(citem.getPants());
            ClothingItem.setShorts(citem.getShorts());
            ClothingItem.setSocks(citem.getSocks());
        }
        else if (activity.equals("Toy")) {
            Toys titem = (Toys) savedInstanceState.getSerializable("ToyActivity");
            FoodItem.setUsername(titem.getUsername());
            ToyItem.setUsername(titem.getUsername());
            ClothingItem.setUsername(titem.getUsername());
            ToyItem.setBlocks(titem.getBlocks());
            ToyItem.setBooks(titem.getBooks());
            ToyItem.setLegos(titem.getLegos());
            ToyItem.setElectronics(titem.getElectronics());
            ToyItem.setVideoGames(titem.getVideoGames());
            matchBtn.setText("READY TO MATCH " + ToyItem.getUsername() + " " + Integer.toString(ToyItem.getVideoGames()) +
                    " " + Integer.toString(ToyItem.getElectronics())  + "?");
        }


        matchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.InsertFood(FoodItem);
                dbHelper.InsertClothing(ClothingItem);
                dbHelper.InsertToys(ToyItem);
                startActivity(new Intent(SelectionActivity.this, MapActivity.class));
            }
        });


        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = Item.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ItemAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {


            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {


                Log.d("TEST", expandableListTitle.get(groupPosition));
                if(expandableListTitle.get(groupPosition).equals("  Food")){
                    Intent intent = new Intent(SelectionActivity.this , FoodActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("FoodObject", FoodItem);
                    intent.putExtras(bundle);
                    intent.setClass(SelectionActivity.this, FoodActivity.class);
                    startActivity(intent);
                }
                if(expandableListTitle.get(groupPosition).equals("  Clothing")){
                    Intent intent = new Intent(SelectionActivity.this , ClothesActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ClothesObject", ClothingItem);
                    intent.putExtras(bundle);
                    intent.setClass(SelectionActivity.this, ClothesActivity.class);
                    startActivity(intent);
                }
                if(expandableListTitle.get(groupPosition).equals("  Children's Toys")){
                    Intent intent = new Intent(SelectionActivity.this , ToyActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ToyObject", ToyItem);
                    intent.putExtras(bundle);
                    intent.setClass(SelectionActivity.this, ToyActivity.class);
                    startActivity(intent);
                }

                return false;
            }
        });

        Toolbar actionBarToolbar = (Toolbar) findViewById(toolbar);
        setSupportActionBar(actionBarToolbar);

        getSupportActionBar().setTitle("");
    }
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id == R.id.settings) {
            startActivity(new Intent(SelectionActivity.this, MainActivity.class));
        }

        return true;
    }
}