package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=(TextView) findViewById(R.id.Text_for_Toast);

        b=(Button) findViewById(R.id.Button_For_Toast);


        // Here making OnClickListner , jub tak click nai ho ga aus waqt tak toast(alert ya message) kesa aye ga
        // tbhe yehan pa mena OnClickListner pa Toast lgya ha

       t.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getApplicationContext() , "This is The Toast On Text inside OnClickListner " , Toast.LENGTH_LONG).show();
           }
       });


       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getApplicationContext(),"This is the Toast On Button Inside OnClickListner",Toast.LENGTH_LONG).show();
           }
       });





    }
}
