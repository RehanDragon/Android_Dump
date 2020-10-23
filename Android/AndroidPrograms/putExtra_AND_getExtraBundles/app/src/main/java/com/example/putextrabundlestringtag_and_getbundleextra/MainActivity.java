package com.example.putextrabundlestringtag_and_getbundleextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    EditText in1,in2;
    Button act;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        in1= (EditText) findViewById(R.id.input1);
        in2= (EditText) findViewById(R.id.input2);

        act=(Button) findViewById(R.id.action);



        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               int a =  Integer.parseInt(  in1.getText().toString()  )   ;

               int b =  Integer.parseInt(   in2.getText().toString()       );

               int c = a+b;
               int hj=a-b;

               Bundle bd = new Bundle();

               bd.putInt("bundle key 1",c );
               bd.putInt("bundle key 2" , hj);

               Intent i = new Intent(getApplicationContext(),ResultShowing.class);


               i.putExtra("key1" ,  bd   );


               startActivity(i);






            }
        });





    }
}
