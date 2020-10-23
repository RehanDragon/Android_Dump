package com.example.intentswithgetextraandputextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class screenforresult extends AppCompatActivity {
TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screenforresult);

    result = (TextView) findViewById(R.id.result);


    double displaying_result =  getIntent().getDoubleExtra("result" ,0);

    double result_ = getIntent().getDoubleExtra("result",0);


    // what does this mean then
        // result.setText(result +"");
    result.setText(   String.valueOf(result_)   );


       // Intent result_coming_here = getIntent();

//result mera put main mojude ha
       // result_coming_here.getExtras().get("result");

       // result.setText(result_coming_here.get) );

        //result_coming_here.getStringExtra("result" );
        //String s1 = result_coming_here.getStringExtra("result");
        //result.setText(s1);


    }
}
