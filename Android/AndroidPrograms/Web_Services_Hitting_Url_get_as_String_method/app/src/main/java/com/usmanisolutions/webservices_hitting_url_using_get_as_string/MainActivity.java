package com.usmanisolutions.webservices_hitting_url_using_get_as_string;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

public class MainActivity extends AppCompatActivity {

    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());

        t=(TextView) findViewById(R.id.txt1);
        b=(Button) findViewById(R.id.request);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Android networking pa url get kr wao
                priority set kro url ke
                ausa build kro ausa

                ausa build to kro likan kis format main

                ausa build kro  string k format main

                new lgao

                String request listener lgao

                aur apne text field k variable pa response set kr do jo button hit krna k bad aye ga






                 */

                AndroidNetworking.get(/*String format main url get kro*/"https://fierce-cove-29863.herokuapp.com/getAnUserDetail/2")
                        .setPriority(Priority.HIGH)
                        .build()
                        // yehan pa method k ander interface lgya ha
                        .getAsString(/*String request listiner*/new StringRequestListener()/*String Request Listner humare pas aik interface ha jis k ander 2 method define  hue hain jo k implement krna huma lazmi hain*/ {
                            @Override
                            public void onResponse(String response) {
                                //text field pa response set kr do
                                t.setText(response);
                            }

                            @Override
                            public void onError(ANError anError) {

                            }
                        });

            }
        });
    }
}
