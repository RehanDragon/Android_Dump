package com.example.intents_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondScreen extends AppCompatActivity {

    TextView s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

   s1= (TextView) findViewById(R.id.screen2);

    }
}
