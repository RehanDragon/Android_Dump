package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Menu = (TextView) findViewById(R.id.txt_MENU);

// first we need to set On Click Listner
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mera_intent = new Intent(getApplicationContext() ,Menu_Shift.class);

                startActivity(mera_intent);
            }
        });




    }
}
