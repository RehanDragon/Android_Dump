package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread t = new Thread(){
            @Override
            public void run() {

                try{

                    sleep(2000);


                    Intent i = new Intent(getApplicationContext(), MainActivity.class);



                    startActivity(i);

                    finish();











                }catch(Exception e)
                {}



            }
        };
        t.start();




    }
}
