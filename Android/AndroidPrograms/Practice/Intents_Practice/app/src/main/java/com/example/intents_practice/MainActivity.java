package com.example.intents_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   f1=(TextView) findViewById(R.id.first_screen);


        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  i= new Intent(getApplicationContext() ,secondScreen.class);

                startActivity(i);
            }
        });

    }
}
