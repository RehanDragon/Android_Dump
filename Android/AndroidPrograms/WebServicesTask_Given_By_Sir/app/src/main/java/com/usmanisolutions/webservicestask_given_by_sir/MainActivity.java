package com.usmanisolutions.webservicestask_given_by_sir;

import androidx.appcompat.app.AppCompatActivity;
//this is all wrong
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText input_email,input_password;
    Button login;
    String Stored_email="rehanusmani.ssuet@gmail.com";
     String Stored_password="123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());

        input_email=(EditText) findViewById(R.id.input_email);
        input_password= (EditText) findViewById(R.id.input_password);

        login=(Button) findViewById(R.id.login);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*String email= input_email.getText().toString();
                String pass= input_password.getText().toString();*/

                AndroidNetworking.post("https://fierce-cove-29863.herokuapp.com/createAnUser")
                        /*.addBodyParameter("Stored_email")
                        .addBodyParameter("Stored_password")*/
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                if( input_email.getText().equals(Stored_email) && input_password.getText().equals(Stored_password) )
                                {
                                    Toast.makeText(MainActivity.this, "login sucessfull", Toast.LENGTH_SHORT).show();
                                }
                                else
                                    {
                                        Toast.makeText(MainActivity.this, "login unsucessfull", Toast.LENGTH_SHORT).show();
                                    }
                            }

                            @Override
                            public void onError(ANError anError) {

                            }
                        });

                ;







            }
        });



    }
}
