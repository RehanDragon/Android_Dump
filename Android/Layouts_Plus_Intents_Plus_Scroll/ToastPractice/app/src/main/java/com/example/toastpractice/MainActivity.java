package com.example.toastpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.Hello_World);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // this is how we make Toast
               Toast.makeText( getApplicationContext() ,"This is basic Hello World program",Toast.LENGTH_SHORT).show();



            }
        });




    }
}
