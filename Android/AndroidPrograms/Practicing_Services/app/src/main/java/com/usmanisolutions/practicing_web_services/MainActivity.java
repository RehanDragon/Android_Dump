  package com.usmanisolutions.practicing_web_services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

  public class MainActivity extends AppCompatActivity {

     private EditText username,pass;
      private Button  login;
      TextView response_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AndroidNetworking.initialize(getApplicationContext());


        // sub kuch button k click k ander ho ga

        username=(EditText) findViewById(R.id.username);
        pass=(EditText) findViewById(R.id.pass);
        login=(Button) findViewById(R.id.login);
        response_output=(TextView) findViewById(R.id.response_output);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   String val1=username.getText().toString();
                String val2=pass.getText().toString();
*/
//https://petstore.swagger.io/#/user/loginUser
                AndroidNetworking.get("https://petstore.swagger.io/v2/user/login?username&password")
                        .addPathParameter("username",username.getText().toString())
                        .addPathParameter("password",pass.getText().toString())
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsJSONArray(new JSONArrayRequestListener() {
                            @Override
                            public void onResponse(JSONArray response) {
                                try{

                                    // yehan pa hum na simple Json object lia ha  Json Array nai lia

                                    //tbhe simple get string lia ha aur parse int nai kr waya

                                    // agr hum Jason array kr wate to parse int krwate ku ka aus pa index value mojude hote hain jo ka int values hote hain

                                    // aur Jason Objet ka ander simple string hota ha

                                    if(response.equals(Integer.parseInt("successful operation")) )
                                            {
                                                    response_output.setText(response.getString(Integer.parseInt("username")));
                                    response_output.setText(response.getString(Integer.parseInt("password")));


                                    Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
                                    }


                                    else
                                    {
                                        Toast.makeText(MainActivity.this, "nothing happen", Toast.LENGTH_SHORT).show();
                                    }


                                }

                                catch(JSONException e)
                                {

                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(MainActivity.this, "login not success", Toast.LENGTH_SHORT).show();
                            }
                        });
                       /* .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try{

                                    // yehan pa hum na simple Json object lia ha  Json Array nai lia

                                    //tbhe simple get string lia ha aur parse int nai kr waya

                                    // agr hum Jason array kr wate to parse int krwate ku ka aus pa index value mojude hote hain jo ka int values hote hain

                                    // aur Jason Objet ka ander simple string hota ha

                                    if(response.equals(true)*//*equals(Integer.parseInt("200") )*//*)
                                    {
                                        response_output.setText(response.getString("username"));
                                        response_output.setText(response.getString("password"));


                                        Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
                                    }


                                    else
                                        {
                                            Toast.makeText(MainActivity.this, "nothing happen", Toast.LENGTH_SHORT).show();
                                        }


                                }

                                catch(JSONException e)
                                {

                                }





                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(MainActivity.this, "login not success", Toast.LENGTH_SHORT).show();
                            }
                        });*/




            }
        });




    }
}
