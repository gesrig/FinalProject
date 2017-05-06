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

public class FoodActivity extends AppCompatActivity{
    private Button addItemF;
    private TextView text;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_select);

        addItemF = (Button) findViewById(R.id.addFoodButton);
        savedInstanceState = getIntent().getExtras();
        final Food fooditem = (Food) savedInstanceState.getSerializable("FoodObject");
        text = (TextView) findViewById(R.id.GiveProfMessage) ;
        text.setText(fooditem.getUsername());



        addItemF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(FoodActivity.this , SelectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("FoodActivity", fooditem);
                intent.putExtras(bundle);
                intent.putExtra("Activity", "Food");
                intent.setClass(FoodActivity.this, SelectionActivity.class);
                startActivity(intent);
            }
        });

    }


}
