package com.example.onclicklistner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    t = (TextView) findViewById(R.id.text_for_on_click_listner_to_work);


    t.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            t.setText("This is how OnClickListener Work");
        }
    });




    }
}
