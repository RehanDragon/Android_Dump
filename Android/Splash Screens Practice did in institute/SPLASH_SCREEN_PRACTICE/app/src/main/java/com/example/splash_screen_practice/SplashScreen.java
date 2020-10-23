package com.example.splash_screen_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread t= new Thread()
        {
            public void run(){
//run k ander sleep  ka method lga ga , aur sleep ko hum try catch k ander lain ga
// intent bhe try catch k ander likhain ga sleep ka method k sat
// finish()  <--- finish ka method bhe try catch k ander likhain ga , finish humare pas splash screen ko khatem krta ha ga

                 try{
                     sleep(7000);
                     Intent i= new Intent(getApplicationContext() , MainActivity.class);
                     startActivity(i);
                     finish();

                 }

                 catch(Exception e){}




            }






        };
        t.start();







    }
}
