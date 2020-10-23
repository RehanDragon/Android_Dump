package com.example.intentswithgetextraandputextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText input1,input2;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    input1 = (EditText) findViewById(R.id.input1);
    input2 = (EditText) findViewById(R.id.input2);

    add = (Button) findViewById(R.id.add);



    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MyFunction obj = new MyFunction();


            double a  = Double.parseDouble(input1.getText().toString());

            double b = Double.parseDouble(input2.getText().toString());

           double c= obj.addition(a,b);


            Intent intent_to_go_to_new_screen  = new Intent(getApplicationContext() ,screenforresult.class);






// converted jo k parse ho gye ha aus value ko dalain ga ais main
            intent_to_go_to_new_screen.putExtra("result" ,c);

            startActivity(intent_to_go_to_new_screen);




        }
    });


    }





}

    class MyFunction{

    public static double addition( double a , double b)
    {
        return a+b;
    }

}