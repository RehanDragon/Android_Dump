package com.usmanisolutions.web_services_by_getjasonobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button hit;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());
        input = (EditText) findViewById(R.id.input);
        hit = (Button) findViewById(R.id.hit);

        t1=(TextView) findViewById(R.id.txt1);
        t2=(TextView) findViewById(R.id.txt2);
        t3=(TextView) findViewById(R.id.txt3);

        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String val = ed.getText().toString();
                String value_input = input.getText().toString();

                AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUserDetail/"+value_input)

                        .setPriority(Priority.HIGH)

                        .build()

                        .getAsJSONObject

                                (

                                new JSONObjectRequestListener()

                {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            t1.setText(  "Entered id : " +   response.getString("id"));
                            t2.setText(  "First Name : " +   response.getString("firstname"));
                            t3.setText(  "Last Name  : " +   response.getString("lastname"));
                        } catch (JSONException e) {

                           // this print stack trace just shows the error message
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                }

                );




            }
        });




    }}