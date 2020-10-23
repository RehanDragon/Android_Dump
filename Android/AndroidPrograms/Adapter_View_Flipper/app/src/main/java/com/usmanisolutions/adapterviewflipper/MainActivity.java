package com.usmanisolutions.adapterviewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterViewFlipper;

public class MainActivity extends AppCompatActivity {

    private AdapterViewFlipper simpleAdapterViewFlipper;

    int[] fruitImages={R.drawable.i1,R.drawable.i2,R.drawable.i3};

    String fruitNames[] = {"this is image 1","this is image 2","this is image 3"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        simpleAdapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.simpleAdapterFlipper); // get reference of adapter view flipper


        // custom adapter for setting the data in views

CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),fruitNames,fruitImages);
simpleAdapterViewFlipper.setAdapter(customAdapter);
simpleAdapterViewFlipper.setFlipInterval(3000);
simpleAdapterViewFlipper.setAutoStart(true);


    }
}
