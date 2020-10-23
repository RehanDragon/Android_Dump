package com.usmanisolutions.practice_reviewing_android_even_odd_calculator_making;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.btnCheck);
        editText= (EditText) findViewById(R.id.edTxValueEnter);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                       //Integer ke value le parseInt sa
                       //Value ko String main convert kr dia toString sa wapse
            double input=  Double.parseDouble(editText.getText().toString() );

            if(input % 2 == 0 )
            {
               editText.setText(" Even Number ");
            }
            else
                {
                    editText.setText("Odd Number");
                }


        }
    });


    }
}