package com.example.adding_two_numbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1 , num2 ;
    private Button add;
    private TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num1= (EditText) findViewById(R.id.ed_txt_num_1);
        num2= (EditText) findViewById(R.id.ed_txt_num_2);
        add=   (Button)    findViewById(R.id.btn_add);
        ans = (TextView) findViewById(R.id.ans);







        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int    a = Integer.parseInt( num1.getText().toString() );
                int    b = Integer.parseInt( num2.getText().toString() );

                int addition = a+b;

                ans.setText( String.valueOf(addition)   );




            }
        });


    }
}
