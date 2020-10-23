package com.example.mon27_;

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
   txt= (TextView) findViewById(R.id.txt);

        SharedPreferences sp = getSharedPreferences("data" , MODE_PRIVATE);
       String n =  sp.getString("username" , "zero"); // here zero is the default text or  default String value that ew had set
                                                             // where as default integer value is zero
        txt.setText(n);




    }
}
