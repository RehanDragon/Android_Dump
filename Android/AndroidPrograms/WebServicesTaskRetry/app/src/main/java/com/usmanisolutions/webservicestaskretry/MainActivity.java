package com.usmanisolutions.webservicestaskretry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText input_name;
    Button login;

    String username,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());

        input_name=(EditText) findViewById(R.id.input_name);


        login=(Button) findViewById(R.id.login);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name= input_name.getText().toString();

                /*Link used =     https://api.github.com/users     */

                AndroidNetworking.get("https://api.github.com/users/"+name)
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    username = response.getString("name");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                Toast.makeText(MainActivity.this, "login", Toast.LENGTH_SHORT).show();

                            }



                            @Override
                            public void onError(ANError anError) {

                                Toast.makeText(MainActivity.this, "not login", Toast.LENGTH_SHORT).show();
                            }
                        });

                ;







            }
        });


    }
}
