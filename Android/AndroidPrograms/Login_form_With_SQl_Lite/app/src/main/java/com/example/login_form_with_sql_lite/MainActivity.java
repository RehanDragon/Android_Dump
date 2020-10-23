package com.example.login_form_with_sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
   static Button register,login_now;
   static EditText fname,lname,pass,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.button);

        openHelper = new DatabaseOpenHelper(this);
        fname =(EditText) findViewById(R.id.first_name);
        lname =(EditText) findViewById(R.id.last_name);
        pass =(EditText) findViewById(R.id.password);
        email =(EditText) findViewById(R.id.email);
        phone =(EditText) findViewById(R.id.phone);
        login_now =(Button) findViewById(R.id.login_Now);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db=openHelper.getWritableDatabase();

             String    Fname = fname.getText().toString();
             String    Lname = lname.getText().toString();
             String    Pass = pass.getText().toString();
             String    Email = email.getText().toString();
             String    Phone = phone.getText().toString();

             insertdata(Fname,Lname,Pass,Email,Phone);

                Toast.makeText(getApplicationContext(),"register successfully ",Toast.LENGTH_SHORT).show();



            }
        });










        // this is the button for Login

        login_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this/*MinActivity class sa jump ho*/ , login.class /*aur login class pa jao*/  );

                startActivity(i);
            }
        });

    }



    public void insertdata(String fname , String lname , String pass , String email , String phone )
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseOpenHelper.COL_2,fname);
        contentValues.put(DatabaseOpenHelper.COL_3,lname);
        contentValues.put(DatabaseOpenHelper.COL_4,pass);
        contentValues.put(DatabaseOpenHelper.COL_5,email);
        contentValues.put(DatabaseOpenHelper.COL_6,phone);


        long id  = db.insert(DatabaseOpenHelper.TABLE_NAME,null ,contentValues);

    }
}
