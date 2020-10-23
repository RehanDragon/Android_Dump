package com.example.spinnerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //yehan sa code shru ha 
        spinner = (Spinner) findViewById(R.id.spinner);

        String [] countires = {"Pakistan" , "India" , "China" , "Egypt"};




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , android.R.layout.simple_dropdown_item_1line , countires);

        spinner.setAdapter(adapter);

    }
}
