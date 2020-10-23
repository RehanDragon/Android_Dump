package com.example.hittingurls_with_webservices;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button hit;
    TextView out1,out2,out3;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());


        hit= findViewById(R.id.hit);
        out1=findViewById(R.id.output1);
        out2=findViewById(R.id.output2);
        out3=findViewById(R.id.output3);


        input = findViewById(R.id.input_val);


        //Setting Animation here of our layout
        /*ScrollView*/
        /*RelativeLayout animatedLayout = (RelativeLayout) findViewById(R.id.animated_layout);

        AnimationDrawable animationDrawable = *//*cast kra*//* (AnimationDrawable) *//*ScrollView ka jo variable ha wo aye ga*//* animatedLayout.getBackground();

        // now putting fade Duration On AnimationDrawable variable

        animationDrawable.setEnterFadeDuration(2000); // time for entring of one graidient time
        animationDrawable.setExitFadeDuration(4000); //  time for entring of one gradient time
        // now we will start our animation by start method
        animationDrawable.start();*/
// here animated background works become over


        ScrollView perform_animation = (ScrollView) findViewById(R.id.animated_layout_1);

        AnimationDrawable make_animation = (AnimationDrawable) perform_animation.getBackground();

        make_animation.setEnterFadeDuration(2000);
        make_animation.setExitFadeDuration(4000);
        make_animation.start();




        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val =  input.getText().toString();
                AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUserDetail/"+val)
                        .setPriority(Priority.HIGH)
                        .build().getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            out1.setText(response.getString("id"));
                            out2.setText(response.getString("firstname"));
                            out3.setText(response.getString("lastname"));
                        }
                        catch (JSONException e)
                        {

                            //e.printStackTrace();  <--StackTrace error Tracing k lia aitmal hota ha
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
