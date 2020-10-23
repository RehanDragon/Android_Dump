package com.usmanisolutions.text_switcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private TextSwitcher textSwitcher;

    private Button previous,next;

    // names k nam ka aik Array bna lia
    String names[] = {"apple","mango","banana"};

    // aik pointer bna lia

    int currentindex=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next=(Button) findViewById(R.id.btnnext);

        previous= (Button) findViewById(R.id.btnprevious);

        textSwitcher=(TextSwitcher) findViewById(R.id.textswcher);




        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                // make view k method k ander aik nya text view create kro  new k zaria




                TextView text = new TextView(MainActivity.this);

                text.setTextSize(26);


                // ya yad rekho textswitcher k ander text view ha jo hum na bnya ha jo alignment Textswitcher ke ho ge aushe k ander Text ke alignment hue we ha

                // simple  jaisa hum layout k ander button ko center align krta hain bilkul wohe kam ha ya bhe

                text.setTextAlignment(/*View ke class jis pa makeView() ka method lgya ha aus pa lgya ha Alignment*/ View.TEXT_ALIGNMENT_CENTER);

                text.setTextColor(getResources().getColor(R.color.colorAccent));


                return text;
            }
        });


    }



    public void clickbtn(View view) {


        switch (view.getId()/*view ka jo variable ha aus sa  id lo  getId()  k method k zaria */)
        {
            case R.id.btnprevious:

                if(currentindex>0)
                {

                    currentindex=currentindex-1;
                    textSwitcher.setText(names[currentindex]);
                }

                break;

            case R.id.btnnext:

                if(currentindex < names.length-1/*length-1  hu na ais lia ila ha ku ka ArrayOutOfBounds ka Exception na aye humare pas*/)
                {
                    currentindex = currentindex+1;
                    textSwitcher.setText(names[currentindex]);
                }
                break;

        }


    }


}
