package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1= (CheckBox) findViewById(R.id.c1);
        c2= (CheckBox) findViewById(R.id.c2);
      b1=  (Button) findViewById(R.id.btn);


    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(c1.isChecked()==true)
            {


                Toast.makeText(getApplicationContext(),"You like apple",Toast.LENGTH_SHORT).show();
            }
             if (c2.isChecked()==true)
                {
                    Toast.makeText(getApplicationContext(),"You like bnana",Toast.LENGTH_SHORT).show();

                }




        }
    });



    }
}
