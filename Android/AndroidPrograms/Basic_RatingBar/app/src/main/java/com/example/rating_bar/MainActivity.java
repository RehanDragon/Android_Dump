package com.example.rating_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {


    private RatingBar rate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     rate = (RatingBar) findViewById(R.id.ratingbar);


    }
}
