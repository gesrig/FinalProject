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

import static com.example.gregoryesrig24.finalproject.R.id.getButton;

/**
 * Created by gregoryesrig24 on 4/10/17.
 */
import static com.example.gregoryesrig24.finalproject.R.id.toolbar;

public class GetProfile extends AppCompatActivity {

    private Button getButton;
    private EditText inputOrganization, inputStateR, inputCityR, inputStreetR, inputZipR, inputPickUp;
    DBHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getprofile);
        getButton = (Button) findViewById(R.id.getButton);

        dbHelper = new DBHelper(getApplicationContext());
        dbHelper.onUpgrade(dbHelper.getWritableDatabase(), 1, 2);

        inputOrganization = (EditText) findViewById(R.id.CenterName);
        inputStateR = (EditText) findViewById(R.id.StateR);
        inputCityR = (EditText) findViewById(R.id.CityR);
        inputStreetR = (EditText) findViewById(R.id.StreetAddressR);
        inputZipR = (EditText) findViewById(R.id.ZipCodeR);
        inputPickUp = (EditText) findViewById(R.id.PickUp);




        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Organization = inputOrganization.getText().toString();
                String StateR = inputStateR.getText().toString();
                String CityR = inputCityR.getText().toString();
                String StreetR = inputStreetR.getText().toString();
                String ZipcodeR = inputZipR.getText().toString();
                String PickUp = inputPickUp.getText().toString();

                if (TextUtils.isEmpty(Organization)) {
                    Toast.makeText(getApplicationContext(), "Enter User Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(StateR)) {
                    Toast.makeText(getApplicationContext(), "Enter State!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(CityR)) {
                    Toast.makeText(getApplicationContext(), "Enter City!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(StreetR)) {
                    Toast.makeText(getApplicationContext(), "Enter Street!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ZipcodeR)) {
                    Toast.makeText(getApplicationContext(), "Enter Zipcode!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(PickUp)) {
                    Toast.makeText(getApplicationContext(), "Enter if You can PickUP!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {

                    ReceiverUser theUser = new ReceiverUser(Organization, StateR, CityR, StreetR, Integer.parseInt(ZipcodeR), PickUp);
                    dbHelper.InsertUserReceiveInfo(theUser);
                    startActivity(new Intent(GetProfile.this, SelectionActivity.class));
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
            startActivity(new Intent(GetProfile.this, MainActivity.class));
        }

        return true;
    }
}
