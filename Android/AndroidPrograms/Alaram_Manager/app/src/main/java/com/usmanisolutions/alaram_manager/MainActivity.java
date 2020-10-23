package com.usmanisolutions.alaram_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TimePicker timePicker;
    Button setAlaram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timePicker=(TimePicker) findViewById(R.id.timePicker);
        setAlaram=(Button) findViewById(R.id.setAlarm);


        setAlaram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();

                if(Build.VERSION.SDK_INT >= 23)
                {
                    calendar.set(calendar.get(Calendar.YEAR) , calendar.get(Calendar.MONTH) , calendar.get(Calendar.DAY_OF_MONTH),timePicker.getHour() ,timePicker.getMinute(),0);

                }
                else

                    {

                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                                timePicker.getCurrentHour(), timePicker.getCurrentMinute(), 0);

                    }


setAlaram(calendar.getTimeInMillis());


            }
        });



    }

    private void setAlaram(long timeInMillis) {

        AlarmManager alaram_manager_variable = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent i = new Intent(this,MyAlarm.class);

        PendingIntent pi = PendingIntent.getBroadcast(this,0/*?what is request code ??*/,i/*humara intent ka variable*/,0/*what si flag  ???*/);

        alaram_manager_variable.setRepeating(AlarmManager.RTC,timeInMillis/*ais method ka jo variable ha wo ha*/,AlarmManager.INTERVAL_DAY,pi);

        Toast.makeText(this, "Alaram is set", Toast.LENGTH_SHORT).show();



    }
}
