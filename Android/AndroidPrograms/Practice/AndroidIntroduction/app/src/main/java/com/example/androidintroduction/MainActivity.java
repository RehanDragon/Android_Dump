// Task: Click the button and it should name the text view as you had set


package com.example.androidintroduction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView name;
    private Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    name = (TextView) findViewById(R.id.my_text);
    click = (Button) findViewById(R.id.CLICK);

    click.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            name.setText("Hello This is my First Android Program");
        }
    });


    }
}
