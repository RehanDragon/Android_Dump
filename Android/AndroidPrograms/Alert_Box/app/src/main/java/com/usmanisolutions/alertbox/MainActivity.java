package com.usmanisolutions.alertbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText input1,input2;

Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1=(EditText) findViewById(R.id.input1);
        input2=(EditText) findViewById(R.id.input2);
        show=(Button) findViewById(R.id.show);




        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputuser1=input1.getText().toString();
                String inputuser2=input2.getText().toString();





/*
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                //pointer  ko check kro
                {

                    buffer.append(res.getString(0 ));
                    buffer.append(res.getString(1));

                }
*/


StringBuffer buffer = new StringBuffer();

buffer.append(inputuser1);
buffer.append(inputuser2);

// buffer sa hum na append kr waya text ko
                showdata("Data",buffer.toString() /*to String hum na ais lia kra ku ka huma aisa String main wapsi convert kerna tha append kerwana ka bad*/ );

            }
        });
    }


    public void showdata(String title ,String in1 )
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);

        builder.setMessage(in1);

        builder.show();


    }
}
