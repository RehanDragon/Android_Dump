package com.example.intents_in_android_working;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn = (Button) findViewById(R.id.btn_click);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent  Intent_for_screen2 = new Intent(getApplicationContext() , secondScreen.class);
            startActivity(Intent_for_screen2);

        }
    });


    }
}
