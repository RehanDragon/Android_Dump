package com.example.syedjawadali.online_class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ViewSwitcher;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private TextSwitcher textSwitcher;
private Button previous , next;

String names[] = {"apple" , "mango" ,"banana" };
int currentindex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       next =  findViewById(R.id.btnnext);
       previous =  findViewById(R.id.btnprevious);

       textSwitcher= (TextSwitcher) findViewById(R.id.textswcher);
       textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
           @Override
           public View makeView() {
               TextView text = new TextView(getApplicationContext());
               text.setTextSize(26);
               text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
               text.setTextColor(getResources().getColor(R.color.colorAccent));

               return text;
           }
       });







    }

    public void clickbtn(View view){

        switch (view.getId()){

            case R.id.btnprevious:
                if(currentindex>0){

                    currentindex = currentindex-1;
                    textSwitcher.setText(names[currentindex]);

                }
                break;
            case R.id.btnnext:

                if(currentindex<names.length-1){

                    currentindex = currentindex+1;
                    textSwitcher.setText(names[currentindex]);

                }

                break;

        }

    }

}
