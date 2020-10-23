package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
Button click;
TextView ans;

// over here we take shared preferences we will not create any XML file over here
    // automatically class will will be imported


    SharedPreferences data_holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button_show);
        ans = (TextView) findViewById(R.id.result);


// first we get the value of shared preference value  where we named our shared preferences as (data)
        // and stored it in data_holder variable
        data_holder = getSharedPreferences("data",MODE_PRIVATE);


    click.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

             data_holder.edit().putString(/*first we define a key in String*/ "user1" ,/*after that we define a string value which we want to associate with that key so when we will call that key this value will be called*/"rehan" ).apply();



             String data_getter = data_holder.getString("user1","user  found");

             ans.setText(data_getter);


        }
    });



    }



}
