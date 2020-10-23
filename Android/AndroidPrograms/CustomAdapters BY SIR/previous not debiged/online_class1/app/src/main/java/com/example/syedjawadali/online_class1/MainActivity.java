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


  private AdapterViewFlipper flipper;
  int[] Images = {

R.drawable.i1,
          R.drawable.i2,
          R.drawable.i3




  };


  String Names []= {

          "Silder one ka text",
          "Slider two ka text",
          "Slider three ka Text"


  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        flipper = (AdapterViewFlipper)findViewById(R.id.flipper);
        CustomAdapter obj = new CustomAdapter(getApplicationContext() , Names , Images);
        flipper.setAdapter(obj);
        flipper.setFlipInterval(1000);
        flipper.setAutoStart(true);










    }

    }


