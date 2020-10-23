package com.example.practice_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Spinner_activity extends AppCompatActivity {


    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_activity);

        spinner = (Spinner) findViewById(R.id.spinner);

        String [] countires = {"Pakistan" , "India" , "China" , "Egypt"};
        String []  capital = {"Karachi" , "New Delhi" , "Beijing" , "Cairo"};



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , android.R.layout.simple_dropdown_item_1line , countires);

        spinner.setAdapter(adapter);





    }
}
