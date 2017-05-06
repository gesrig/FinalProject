package com.example.gregoryesrig24.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by michaelpenny on 5/3/17.
 */

public class ClothesActivity extends AppCompatActivity{
    private Button addItemC;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothes_select);
        addItemC = (Button) findViewById(R.id.addClothesButton);


        savedInstanceState = getIntent().getExtras();
        final Clothing clothesitem = (Clothing) savedInstanceState.getSerializable("ClothesObject");


        addItemC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ClothesActivity.this , SelectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ClothingActivity", clothesitem);
                intent.putExtras(bundle);
                intent.putExtra("Activity", "Clothes");
                intent.setClass(ClothesActivity.this, SelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}
