package com.example.spinner_prabin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spincountry;
    private Spinner countryplayer;
    private AutoCompleteTextView autoCompleteTextView;

    public String[] Country = {"Nepal", "India"};
    public String[] indiannplayer = {"raman", "manish", "mahesh"};
    public String[] nepaliplayer = {"rajesh", "nikhil"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spincountry = findViewById(R.id.spincountry);
        countryplayer = findViewById(R.id.countryplayer);
        autoCompleteTextView = findViewById(R.id.autocompleteTextView);

//auto
        ArrayAdapter<String> stringArrayAdapter22 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item,nepaliplayer);
        autoCompleteTextView.setAdapter(stringArrayAdapter22);
        autoCompleteTextView.setThreshold(1);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                Country
        );
        spincountry.setAdapter(adapter);

        spincountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spincountry.getSelectedItem().toString().equals("India")) {
                    ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            indiannplayer);
                    countryplayer.setAdapter(arrayAdapter);
                } else {
                    ArrayAdapter adapterarray = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, nepaliplayer);

                    countryplayer.setAdapter(adapterarray);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        }
    }



