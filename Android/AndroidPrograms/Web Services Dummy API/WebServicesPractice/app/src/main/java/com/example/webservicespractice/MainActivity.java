package com.example.webservicespractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {
EditText name,pass;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());

        name =(EditText) findViewById(R.id.name);
        pass =(EditText) findViewById(R.id.pass);
        login=(Button) findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*login  ke priority high hote ha aksar*/
                AndroidNetworking.get("myapi/user/auth?name&pass")
                        .addPathParameter("name"/*name  ke aik key value jo url main ha wo likhain ga ,yehan pa name url main define tha tbhe likha ha , aur aus main hum user input dalain ga*/,name.getText().toString()/*yehan pa hum na user input dal dia */)
                        .addPathParameter("pass",pass.getText().toString())
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsJSONArray(new JSONArrayRequestListener() {
                            @Override
                            public void onResponse(JSONArray response) {

                        /*try {
                            response.getString(Integer.parseInt("name"));
                            response.getString(Integer.parseInt("pass"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/

                                try {
                                    if(response.equals("success")  )
                                    {
                                        Toast.makeText(MainActivity.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();

                                        Intent I = new Intent(MainActivity.this,Account_Page.class);
                                        startActivity(I);

                                    }

                                    else

                                    {
                                        Toast.makeText(MainActivity.this, "Login Unsucessfull", Toast.LENGTH_SHORT).show();

                                        Intent i = new Intent(MainActivity.this,MainActivity.class);

                                        startActivity(i);


                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                            }

                            @Override
                            public void onError(ANError anError) {

                            }
                        });

            }
        });



    }
}
