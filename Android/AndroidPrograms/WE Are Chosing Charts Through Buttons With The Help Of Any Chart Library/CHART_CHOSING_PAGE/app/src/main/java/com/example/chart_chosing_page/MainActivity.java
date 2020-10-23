package com.example.chart_chosing_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button chart1,chart2,chart3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chart1 = (Button) findViewById(R.id.chart1);

        chart2= (Button) findViewById(R.id.chart2);

        chart3= (Button) findViewById(R.id.chart3);


        // working for chart 1
        chart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), PI_Chart.class );

                startActivity(i);




            }
        });


        // working for chart 2

        chart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent i = new Intent(getApplicationContext(),Column_Chart.class);
              startActivity(i);

            }
        });



        // working for chart 3

        chart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(),LineChart.class);

                startActivity(i);



            }
        });




    }
}
