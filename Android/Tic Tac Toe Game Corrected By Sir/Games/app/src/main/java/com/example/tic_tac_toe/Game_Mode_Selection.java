package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game_Mode_Selection extends AppCompatActivity {

    private Button Option1;
    private Button Option2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__mode__selection);

    Option1= (Button) findViewById(R.id.btn_option_1);



    Option1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent i = new Intent(getApplicationContext(),MainActivity.class);


            startActivity(i);

        }
    });



    Option2= (Button) findViewById(R.id.btn_option_2);

    Option2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(),Player_VS_Player.class);

            startActivity(i);
        }
    });




    }
}
