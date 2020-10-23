package com.example.login_form_with_sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {


    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button btnLogin;
    EditText login_Email, login_Pass;

    CheckBox rememberme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_Email=(EditText)findViewById(R.id.login_email);
        login_Pass=(EditText)findViewById(R.id.login_password);
        btnLogin=(Button)findViewById(R.id.login);
        openHelper=new DatabaseOpenHelper(this);
        db = openHelper.getReadableDatabase();

        rememberme=(CheckBox) findViewById(R.id.checkBox);




        // this work over here is only for Remember me work on login screen
        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);

        String checkbox =preferences.getString("remember","");

        if(checkbox.equals(true))
        {

            Intent i = new Intent(getApplicationContext(),WelcomeScreen.class);
            startActivity(i);
        }
        else if (checkbox.equals("false"))
        {

            Toast.makeText(this ,"Please Sign In .",Toast.LENGTH_SHORT).show();
        }




        // this is the work of login work
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = login_Email.getText().toString();
                String pass = login_Pass.getText().toString();


                cursor = db.rawQuery("SELECT *FROM " + DatabaseOpenHelper.TABLE_NAME + " WHERE " + DatabaseOpenHelper.COL_5 + "=? AND " + DatabaseOpenHelper.COL_4 + "=?", new String[]{email, pass});




                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                    }
                }


                Intent i = new Intent (login.this , WelcomeScreen.class);
                startActivity(i);







            }
        });


rememberme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        if(compoundButton.isChecked() )
        {

            SharedPreferences preferences =  getSharedPreferences("checkbox"/*this is our file name*/,MODE_PRIVATE);

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("remember","true");
            editor.apply();
            Toast.makeText(login.this,"Checked",Toast.LENGTH_SHORT).show();


        }
        else if (!compoundButton.isChecked() )

        {
            SharedPreferences preferences =  getSharedPreferences("checkbox"/*this is our file name*/,MODE_PRIVATE);

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("remember","false");
            editor.apply();
            Toast.makeText(login.this,"UnChecked",Toast.LENGTH_SHORT).show();

        }




    }
});

    }

}
