package com.usmanisolutions.hittingurls_with_web_services_getasjsonobject;

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
TextView id,fname,lname;
EditText input;
Button hit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());



      id=  (TextView) findViewById(R.id.id);
       fname= (TextView) findViewById(R.id.fname);
       lname= (TextView) findViewById(R.id.last_name);
       input= (EditText) findViewById(R.id.input);
        hit= (Button) findViewById(R.id.hit);


hit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String val= input.getText().toString();

        AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUserDetail/"+val)
        .setPriority(Priority.HIGH)
        .build().getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    id.setText( response.getString("id") );
                    fname.setText( response.getString("firstname")  );
                    lname.setText( response.getString("lastname")  );
                } catch (JSONException e) {
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
