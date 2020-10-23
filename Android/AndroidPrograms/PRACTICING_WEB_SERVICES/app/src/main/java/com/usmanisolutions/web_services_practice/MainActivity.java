package com.usmanisolutions.web_services_practice;

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
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText id,email,first_name,last_name;

    private Button hit;

    private TextView response_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());


        id=(EditText) findViewById(R.id.id);
        email=(EditText) findViewById(R.id.email);
        first_name=(EditText) findViewById(R.id.first_name);
        last_name=(EditText) findViewById(R.id.last_name);
        hit=(Button) findViewById(R.id.hit);
        response_result=(TextView) findViewById(R.id.response_result);


       hit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               AndroidNetworking.get("https://reqres.in/api/users/{}" )

                       /*.addPathParameter("email",email.getText().toString())
                       .addPathParameter("first_name",first_name.getText().toString()  )
                       .addPathParameter("last_name",last_name.getText().toString()    )*/

                       .setPriority(Priority.HIGH)
                       .build()
                       .getAsJSONObject(new JSONObjectRequestListener() {
                           @Override
                           public void onResponse(JSONObject response) {



                               Toast.makeText(MainActivity.this, " login success ", Toast.LENGTH_SHORT).show();

                               response_result.setText(response.toString());  // ais sa to pura data auth ka a gye ga jo bhe url main mojude ha


                               /*try {
                                   response_result.setText(response.getString("id"));

                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }*/


                             /*  try {
                                   response_result.setText(response.getString("id"));
                                   response_result.setText(response.getString("email"));
                                   response_result.setText(response.getString("first_name"));
                                   response_result.setText(response.getString("last_name"));

                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }*/
                           }

                           @Override
                           public void onError(ANError anError) {

                               Toast.makeText(MainActivity.this, "nothing happen ", Toast.LENGTH_SHORT).show();
                           }
                       });





           }
       });
    }
}
