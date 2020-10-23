package com.example.sharedpreferences_working;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    private TextView txt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txt= (TextView) findViewById(R.id.Text_output);

        SharedPreferences sp = getSharedPreferences("data" , MODE_PRIVATE);
        String n =  sp.getString("username" , "zero");
        txt.setText(n);


    }
}
