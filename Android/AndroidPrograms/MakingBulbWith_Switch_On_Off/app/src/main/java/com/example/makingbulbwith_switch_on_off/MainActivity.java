package com.example.makingbulbwith_switch_on_off;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch sw;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw= (Switch) findViewById(R.id.switch_on_off);

        img =(ImageView) findViewById(R.id.imagebulb);



        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //try

                try{
                if(sw.isChecked())
                {
                    img.setImageDrawable(getResources().getDrawable(R.drawable.on));


                }
                else
                    {
                        img.setImageDrawable(getResources().getDrawable(R.drawable.of));
                    }

                }catch(Exception e){}
            //catch


            }
        });




    }
}
