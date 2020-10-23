package com.example.syedjawadali.online_class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ViewSwitcher;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

AdapterViewFlipper flipper;
int[] IMAGES = {
      R.drawable.i1,
      R.drawable.i2,
      R.drawable.i3

};


String NAMES[]= {"image from first","image from second","image from third"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        flipper = (AdapterViewFlipper )findViewById(R.id.adapterfliper);
        CustomAdapter obj = new CustomAdapter(getApplicationContext(),NAMES,IMAGES);


        flipper.setAdapter(obj);

        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);







    }

    }


