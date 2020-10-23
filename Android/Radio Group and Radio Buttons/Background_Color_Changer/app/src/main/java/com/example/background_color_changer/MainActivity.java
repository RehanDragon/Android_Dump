package com.example.background_color_changer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
private RelativeLayout rl;

private RadioButton r1,r2,r3;

//private RadioGroup RG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rl=  (RelativeLayout) findViewById(R.id.layout);

        r1=  (RadioButton) findViewById(R.id.rd_1);

        r2 = (RadioButton) findViewById(R.id.rd_2);

        r3 = (RadioButton) findViewById(R.id.rd_3);

    //    RG = (RadioGroup) findViewById(R.id.RG);







/*
        if(  r1.isSelected()   )
        {
            r1.setBackgroundResource(R.color.colorAccent);

        }


        else if(  r2.isSelected()   )
        {
            r1.setBackgroundResource(R.color.colorPrimaryDark);

        }

        if(  r2.isSelected()   )
        {
            r1.setBackgroundResource(R.color.colorPrimary);

        }

*/




    }



    public void colorselector(View  variable_of_color_selector_method  )
    {

        switch (variable_of_color_selector_method.getId() )


        {

            case R.id.rd_1:
                // layout pa color lgao

                rl.setBackgroundColor(Color.BLUE);

            break;

            case R.id.rd_2:

                rl.setBackgroundColor(Color.RED);

                break;


            case R.id.rd_3:

                rl.setBackgroundColor(Color.GREEN);
                break;





        }



    }




}
