package com.usmanisolutions.date_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
DatePicker datePicker;
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker=(DatePicker) findViewById(R.id.datepicker);
        text=(TextView) findViewById(R.id.text);

// method overloading ho rahe ha yehan pa
Calendar calendar = Calendar.getInstance();
//init = initiate
datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),

        calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {


                text.setText(dayOfMonth + " - " + monthOfYear + " - "+ year);
            }
        }
);

    }
}
