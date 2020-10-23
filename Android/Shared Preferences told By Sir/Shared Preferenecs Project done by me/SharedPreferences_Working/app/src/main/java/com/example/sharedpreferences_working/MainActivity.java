package com.example.sharedpreferences_working;


// this work contain  Shared preferences , shared preferences with intents and On back pressed having Task exit on 2 tap ,
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button click_me;

    private TextView output;


    SharedPreferences sp;


    /*


    Stack Overflow guide

    public void onBackPressed(){
Intent a = new Intent(Intent.ACTION_MAIN);
a.addCategory(Intent.CATEGORY_HOME);
a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(a);

}



    * */

// guide taken from stack over flow


    private static long back_pressed;
    @Override
    public void onBackPressed(){
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
        }
        else{
            Toast.makeText(getBaseContext(), "Press once again to exit",
                    Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }




/*
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                    }

                    public <WelcomeActivity> void onClick(DialogInterface arg0, int arg1) {
                        WelcomeActivity.super.onBackPressed();
                    }
                }).create().show();
    }

*/

/*
    public void onBackPressed() {
        finish();
    }

*/

/*
    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        click_me =  (Button) findViewById(R.id.button)   ;
        output =    (TextView) findViewById(R.id.output) ;


        // yehan pa hum na shared preferences  yane virtual storage bnaye
        //shared preferences ka nam data dia mena data aur aus ko PRIVATE kr dia

        sp = getSharedPreferences("data", MODE_PRIVATE ) ;


        click_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // username hum na key de jo  value hum rekh reha hain aus  ke key dalain ga aur jo chez aus k ander rekhne ha aus ka nam

                // edit huma shared preferences k ander value rekhna main kam ata ha
                //aur wo put kra ta hue he kam aye ga likan get krate hua nai aye ga

                // .apply() ka method sa hum
                sp.edit().putString("username",  "rehan" ).apply();


                String U_name = sp.getString( "username" , "not exist" );

                output.setText(U_name);



                // this is for sending Your data on next Activity


                Intent i = new Intent( getApplicationContext() , Second.class );

                startActivity(i);










            }
        });





    }
}
