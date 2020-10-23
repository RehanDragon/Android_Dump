package com.example.Spinner_Having_array_adapter_with_on_item_selected_listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.array_adapter_with_on_item_selected_listener.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


       Spinner  spinView;

       TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinView = (Spinner) findViewById(R.id.Spinner_View);


        String country[] = {"Pakistan","America","India","China","Germany","London"};


     //   String country[] = new String[5];
/*
        country[0]="Pakistan";
        country[1]="America";
        country[2]="India";
        country[3]="China";
        country[4]="Germany";
        country[5]="London";

*/   // ager hum new kr ka memory allocate krain ga to wo dusre memory main allocate kr dega Arry ko aur wo access nai ho pye ge aur App chrash ho gye ge



        spinView.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,country);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spinView.setAdapter(adapter);





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

// if we will not  use getSelectedItem()  method  it will not show the display that you want to make

        String Spinning = spinView.getSelectedItem().toString();

        display  = (TextView) findViewById(R.id.display);


        if (Spinning.equals("Pakistan"))
        {
            display.setText("State 1");

        }
        else if(Spinning.equals("America"))
        {
            display.setText("State 2");
        }


        else if(Spinning.equals("India"))
        {
            display.setText("State 3");
        }


        else if(Spinning.equals("China"))
        {
            display.setText("State 4");
        }

        else if(Spinning.equals("London"))
        {
            display.setText("State 5");
        }

        else if(Spinning.equals("Germany"))
        {
            display.setText("State 6");
        }

        else
            {

                display.setText("Select any Country");

            }




    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
