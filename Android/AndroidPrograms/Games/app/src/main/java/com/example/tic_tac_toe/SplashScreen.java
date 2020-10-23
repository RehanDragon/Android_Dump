package com.example.tic_tac_toe;


//steps to cerate splash screen

/*
* 1)Create Object of Thread class  like this   Thread any_variable = new Thread(){};
* 2)After creating the Object and after terminator write                any_variable.start();
*
* any_variable <-- it is the  thread that we maked and not we start it
*
* It looks Something like this Thread any_variable = new Thread(){}; any_variable.start();
*
* 3)Come in braces of Thread Object
*
* 4)Write method public void run(){}
*
* 5)Inside run(){} , apply try catch
*
* run()
* {
* try{}catch(Exception e){}
*
* }
*
*
* 6)Inside try catch write sleep  method  sleep(2000);
*
* 7)Inside try catch use Intent,,,,,,,,,,,,, Intent i = new Intent(getApplicationContext(),activity_you_want_to_view_after_this_screen.class)
* 8)start Intent by  startActivity(i);
*
* 9)now use finish method inside the try catch block it finishes your splash screen view time it looks like this ,,,,, finish();
*
* Over all Explanation Template
*
* Thread any_variable = new Thread()
* {
*
* public void run()
*
* {
*
* try{
*
* sleep(2000);
*
* Intent i = new Intent(getApplicationContext(), activity_you_want_to_view_after_this_screen.class);
*
* startActivity(i);
*
* finish();
*
* }
* catch(Exception e){}
*
*
*
* }
*
* };
*
*
* any_variable.start();
*
*
*
*
* */


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread t = new Thread()
        {

            public void run()

            {

                try{


                    sleep(3000);

                    Intent i = new Intent(getApplicationContext(),Game_Mode_Selection.class);

                    startActivity(i);

                    finish();
                }
                catch(Exception e){}



            }



        };
        t.start();


    }
}
