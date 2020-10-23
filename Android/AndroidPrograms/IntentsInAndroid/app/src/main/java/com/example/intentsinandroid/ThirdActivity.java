package com.example.intentsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

   private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        t = (TextView) findViewById(R.id.screen_test_3);





    }
}
