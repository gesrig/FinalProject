package com.example.gregoryesrig24.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by michaelpenny on 5/3/17.
 */

public class ToyActivity extends AppCompatActivity{
    private Button addItemT;
    private TextView text;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toy_select);
        addItemT = (Button) findViewById(R.id.addToyButton);
        text = (TextView) findViewById(R.id.condition) ;

        savedInstanceState = getIntent().getExtras();
        final Toys toyitem = (Toys) savedInstanceState.getSerializable("ToyObject");

        toyitem.setVideoGames(2);
        text.setText(toyitem.getUsername());




        addItemT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ToyActivity.this , SelectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ToyActivity", toyitem);
                intent.putExtras(bundle);
                intent.putExtra("Activity", "Toy");
                intent.setClass(ToyActivity.this, SelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}
