package com.example.db_helpers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText input1,input2;
private Button  b1;

DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);

        input1 = (EditText) findViewById(R.id.input_1);
        input2=  (EditText) findViewById(R.id.input_2);
        b1= (Button) findViewById(R.id.result);


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





    }






}
