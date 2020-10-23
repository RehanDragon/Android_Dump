package com.us.signup_form_and_login_Form_with_sharedPreferences_and_Date_With_SQLliteOpenHelper_Connected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class login extends AppCompatActivity {


    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button btnLogin;
    Button logout;
    EditText login_Email, login_Pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);









        //Setting Animation here of our layout
        RelativeLayout animatedLayout = (RelativeLayout) findViewById(R.id.animated_layout_on_login);

        AnimationDrawable animationDrawable = /*cast kra*/ (AnimationDrawable) /*ScrollView ka jo variable ha wo aye ga*/ animatedLayout.getBackground();

        // now putting fade Duration On AnimationDrawable variable

       animationDrawable.setEnterFadeDuration(2000); // time for entring of one graidient time
        animationDrawable.setExitFadeDuration(4000); //  time for entring of one gradient time
        // now we will start our animation by start method
        animationDrawable.start();
// here animated background works become over














        login_Email=(EditText)findViewById(R.id.login_email);
        login_Pass=(EditText)findViewById(R.id.login_password);
        btnLogin=(Button)findViewById(R.id.login);
        openHelper=new DatabaseOpenHelper(this);
        db = openHelper.getReadableDatabase();






        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = login_Email.getText().toString();
                String pass = login_Pass.getText().toString();

// by this we are selecting our value from database
                cursor = db.rawQuery("SELECT *FROM " + DatabaseOpenHelper.TABLE_NAME + " WHERE " + DatabaseOpenHelper.COL_6 + "=? AND " + DatabaseOpenHelper.COL_5 + "=?", new String[]{email, pass});



// we are aplying condition on our selected database

                // cursor is just like a pointer which checks your rows line by line

                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                        /*  Intent yehan pa aye ge ku ka ager login success ha to intent yehan pa aye ge     */


                        Intent i = new Intent (login.this , Account_page.class);
                        startActivity(i);



                    } else {

                        Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                    }
                }













            }
        });



     //Doing Logout Functionality



        logout= (Button) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                login_Email.setText("");

                login_Pass.setText("");


                Intent i = new Intent(login.this,MainActivity.class);

                startActivity(i);


            }
        });










    }













}
