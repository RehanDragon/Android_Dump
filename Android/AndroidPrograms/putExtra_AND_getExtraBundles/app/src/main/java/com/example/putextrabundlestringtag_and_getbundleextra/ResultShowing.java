package com.example.putextrabundlestringtag_and_getbundleextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultShowing extends AppCompatActivity {
private TextView t,x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_showing);
    t=(TextView) findViewById(R.id.output1);
        x=(TextView) findViewById(R.id.output2);

// yehan pa intent ko get krain ga jo wehan pa kr waya ha
        Intent i = getIntent();

        // yehan pa bundle jo dia tha ausa get kr wain ga

        // jo  key hum na putExtra main dale the wo he hum get Bundle Extra main get kr wain ga
        Bundle b1 = i.getBundleExtra("key1");

        int val1= b1.getInt("bundle key 1");
        int val2= b1.getInt("bundle key 2");

        // here we had done String.valueOf because we needed to converted Integer values , the calculated values back to String.

        t.setText(String.valueOf(val1) );
        x.setText(String.valueOf(val2)  );



    }
}
