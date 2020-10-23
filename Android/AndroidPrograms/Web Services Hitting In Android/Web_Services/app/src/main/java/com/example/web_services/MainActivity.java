package com.example.web_services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.jacksonandroidnetworking.JacksonParserFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    TextView show_data;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_data= (TextView) findViewById(R.id.txt1);
        btn=       (Button) findViewById(R.id.request);

// import Library by Alt+Enter


        /*
        Initializing it with some customization , as it uses OkHttp as networking layer,
        you can pass custom okHttpClient while initializing it.

        * */

        AndroidNetworking.initialize(getApplicationContext());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*

                .getAsString() <-- this method takes the whole data as a string

                * */


                // hum log ais url sa response leta hain
                AndroidNetworking.get("http://dummy.restapiexample.com/api/v1/employee/1")
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsString(
                                new StringRequestListener() {
                            @Override
                            public void onResponse(String response) {
                                // we are setting our response on the TextView

                                show_data.setText(response);

                            }

                            @Override
                            public void onError(ANError anError){

                            }
                        });

                
            }
        });







    }
}
