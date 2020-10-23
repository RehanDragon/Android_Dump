package com.example.ratingbar_with_good_poor_fair_logics;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar r;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        r= (RatingBar) findViewById(R.id.rating);
    b= (Button)   findViewById(R.id.show_logic);

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Float value = r.getRating(); // rating get kr wao


        if(value>=2)
        {
            Toast.makeText(getApplicationContext(),"Good",Toast.LENGTH_SHORT).show();
        }


        else{
            Toast.makeText(getApplicationContext() , "Try hard next time",Toast.LENGTH_SHORT).show();
        }


    }
});

    }
}
