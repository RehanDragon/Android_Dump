package com.usmanisolutions.time_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {


    private TimePicker timePicker;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker=(TimePicker) findViewById(R.id.timepicker);// aisa type casting kehta  hain
       textview=(TextView) findViewById(R.id.textview);


       timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
           @Override
           public void onTimeChanged(TimePicker timePicker, int i, int i1) {

               textview.setText(  i+ "---"+i1);
           }
       });

    }
}
