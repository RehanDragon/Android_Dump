package com.example.exp4j_liabrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {


private Button Equals;

private EditText  result_screen;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Equals = (Button) findViewById(R.id.equal);
    result_screen = (EditText) findViewById(R.id.result_Show);




    Equals.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            /*
* ExpressionBuilder expressionBuilder = new ExpressionBuilder(ed.getText().toString());
                double res = expressionBuilder.build().evaluate();
                ed.setText(String.valueOf(res));
*
* */

// yehan pa maena double ais lia lia ha ku ka Expression builder ke class main ya double main value de hue ha
            ExpressionBuilder expressionBuilder = new ExpressionBuilder(result_screen.getText().toString());



            double res =  expressionBuilder.build().evaluate();
            result_screen.setText(String.valueOf(res));



        }
    });






    }
}
