package com.example.intentswith3screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondScreen extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        t = (TextView) findViewById(R.id.text_1);


        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  IntentScreen3= new Intent(getApplicationContext() , thirdScreen.class);
                startActivity(IntentScreen3);
            }
        });



    }
}
