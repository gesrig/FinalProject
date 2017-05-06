package com.example.gregoryesrig24.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.button;
import static com.example.gregoryesrig24.finalproject.R.id.Name;
import static com.example.gregoryesrig24.finalproject.R.id.toolbar;

/**
 * Created by gregoryesrig24 on 4/10/17.
 */

public class GiveProfile extends AppCompatActivity {

    private Button givingbtn;
    private EditText inputUserName, inputState, inputCity, inputStreet, inputZip, inputMiles;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giveprofile);



        givingbtn = (Button) findViewById(R.id.giveButton);
        inputUserName = (EditText) findViewById(R.id.Name);
        inputState = (EditText)     findViewById(R.id.State);
        inputCity = (EditText)  findViewById(R.id.City);
        inputStreet = (EditText) findViewById(R.id.StreetAddress);
        inputZip = (EditText) findViewById(R.id.ZipCode);
        inputMiles = (EditText) findViewById(R.id.Miles);


        givingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = inputUserName.getText().toString();
                String State = inputState.getText().toString();
                String City = inputCity.getText().toString();
                String Street = inputStreet.getText().toString();
                String Zipcode = (inputZip.getText().toString());
                String Miles = (inputMiles.getText().toString());

                if (TextUtils.isEmpty(UserName)) {
                    Toast.makeText(getApplicationContext(), "Enter User Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(State)) {
                    Toast.makeText(getApplicationContext(), "Enter State!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(City)) {
                    Toast.makeText(getApplicationContext(), "Enter City!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(Street)) {
                    Toast.makeText(getApplicationContext(), "Enter Street!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(Zipcode)) {
                    Toast.makeText(getApplicationContext(), "Enter Zipcode!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(Miles)) {
                    Toast.makeText(getApplicationContext(), "Enter Miles to Drive!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {

                    GiverUser theUser = new GiverUser(UserName, State, City, Street, Integer.parseInt(Zipcode), Integer.parseInt(Miles));



                    Intent intent = new Intent(GiveProfile.this , SelectionActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("GiveUserProfile", theUser);
                    intent.putExtras(bundle);
                    intent.putExtra("Activity", "GiveProfile");
                    intent.setClass(GiveProfile.this, SelectionActivity.class);
                    startActivity(intent);

                }
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
            startActivity(new Intent(GiveProfile.this, MainActivity.class));
        }

        return true;
    }



}