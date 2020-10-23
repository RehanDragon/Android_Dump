package com.example.intentsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btn = (Button) findViewById(R.id.btn_click_me);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            // Intent is a builtin class

            // here we had maked the object of Intent class
            // java ke file ke extension .class hote ha

            Intent object_variable = new Intent(getApplicationContext(),SecondActivity.class);

            startActivity(object_variable);



        }
    });









    }
}
