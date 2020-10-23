package com.example.marksheetby_get_extra_put_extra_in_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    Thread thread_for_splash_screen = new Thread(){

        public  void run(){
//run k ander sleep  ka method lga ga , aur sleep ko hum try catch k ander lain ga
// intent bhe try catch k ander likhain ga sleep ka method k sat
// finish()  <--- finish ka method bhe try catch k ander likhain ga , finish humare pas splash screen ko khatem krta ha ga
// 3000 miliseconds = 3 seconds
            try {
                sleep(3000);

                Intent i = new Intent(getApplicationContext() ,/*ais screen sa jis screen pa jum krna ha auska likhain ga*/ MainActivity.class);
                startActivity(i);



                // yad rekhna finish ka method aye ga khale finish activity nai aye ga
                finish();
            }
            catch (Exception e){}


        }



    };
    // outside the thread class body the we will apply start() method on our object variable
    thread_for_splash_screen.start();



    }
}
