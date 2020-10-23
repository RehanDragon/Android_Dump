package com.example.radio_button_group_and_radio_buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout RL;
    private RadioButton r1,r2,r3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RL =(RelativeLayout) findViewById(R.id.My_Layout);

        r1= (RadioButton) findViewById(R.id.rd1);
        r2= (RadioButton) findViewById(R.id.rd2);
        r3= (RadioButton) findViewById(R.id.rd3);
    
    
    }
    
    
    public void colorchanger(View variable_of_type_view)
    {
        switch (variable_of_type_view.getId())
        {
            case R.id.rd1:
                RL.setBackgroundColor(Color.GREEN);
                break;

            case R.id.rd2:
                RL.setBackgroundColor(Color.RED);
                break;
            case R.id.rd3:
                RL.setBackgroundColor(Color.CYAN);
                break;

        }


        
        
        
    }
    
    
}
