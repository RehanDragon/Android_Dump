package com.example.mon27_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
     private Button btn ;
     private TextView txt ;
     private EditText ed ;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.simple);
        txt = (TextView) findViewById(R.id.text);

    sp = getSharedPreferences("data"  ,MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*
*
* It was of another example
*
*
* // String uname = sp.getString("username" , "doesn't");
                //txt.setText(uname);
*
* */

                // over here sharedPreferences was our variable of Shared preferences on which we had applied shared preferences

                //sharedPreferences.edit().putString("name" , "asdasdas").apply();
                //name =  sharedPreferences.getString("name","doesn't");               // here dosen't is the default value which we had set for the string
                //txt.setText(name);


               // here sp is the variable in which we stored our shared preferences which we get
                // here we will apply .edit method on our variable of shared Preferences interface class
                sp.edit().putString("username" , "jawad").apply();
                Intent i = new Intent(getApplicationContext() , Second.class);
                startActivity(i);











            }
        });

}














    }

