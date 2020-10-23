package com.example.intentsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
 private TextView bait;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    bait = (TextView) findViewById(R.id.btn_click_me);

bait.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent objectvariable2 = new Intent(getApplicationContext() , ThirdActivity.class);

        startActivity(objectvariable2);

    }
});

    }
}
