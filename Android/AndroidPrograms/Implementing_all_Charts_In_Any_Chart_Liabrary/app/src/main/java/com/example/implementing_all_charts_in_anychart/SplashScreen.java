package com.example.implementing_all_charts_in_anychart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    //private ImageView splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


      //  splash=findViewById(R.id.SplashScreen);



        Thread t = new Thread(){


            @Override
            public void run() {

                try {
                    sleep(6000);

                    Intent i = new Intent(getApplicationContext() , MainActivity.class);


                    startActivity(i);

                    finish();

                }
                catch (Exception e)
                {

                }


            }
        }; t.start();








    }
}
