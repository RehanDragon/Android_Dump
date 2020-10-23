package com.example.db_helpers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText input1,input2;
private Button  b1 , btn;

DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this); // this was my class name

        input1 = (EditText) findViewById(R.id.input_1);
        input2=  (EditText) findViewById(R.id.input_2);
        b1= (Button) findViewById(R.id.result);
        btn= (Button) findViewById(R.id.btn);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           boolean  inputs =    db.insert(  input1.getText( ).toString() , input2.getText( ).toString() );


                if(  inputs==true )
                {
                    Toast.makeText(getApplicationContext(), " content stored " , Toast.LENGTH_SHORT).show();
                }

                else
                    {
                        Toast.makeText(getApplicationContext() ," content not stored " , Toast.LENGTH_SHORT).show();
                    }


            }
        });



        /*Cursor aik tareka ka pointer ha */
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Cursor res = db.getall();
        if(res.getCount() == 0){

            showdata("Error" , "nothing found");

            /*

            return over here makes the application un crashable

            it will help the application run fluently without any crash

            * */
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){

            buffer.append(res.getString(0 ));//this is index 0,  just like array its index starts from zero  so database index also starts from 0
            buffer.append(res.getString(1));// this is index 1

        }

        showdata("data" , buffer.toString());


    }
});


    }

    public void showdata(String t , String d){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.create();
        builder.setCancelable(true);
        builder.setTitle(t) ;
        builder.setMessage(d);
        builder.show();




    }


}
