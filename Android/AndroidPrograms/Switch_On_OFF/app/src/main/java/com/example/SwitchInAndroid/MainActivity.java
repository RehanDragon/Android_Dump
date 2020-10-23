package com.example.SwitchInAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Switch switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switcher = (Switch) findViewById(R.id.switcher);


        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switcher.isChecked() == true)
                {
                    Toast.makeText(getApplicationContext() ,"Switch is on",Toast.LENGTH_SHORT).show();
                }

                else
                    {
                    Toast.makeText(getApplicationContext() ,"Switch is off",Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}
