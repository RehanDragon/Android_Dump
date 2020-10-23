package com.example.making_calculator_by_expj4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    EditText display;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnplus, btnminus, btnmultiply, btndevide, btnequal, btnclear, btndot;


// method for Responsive Screen Sizes


    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        float density = getResources().getDisplayMetrics().density;
        int newScreenWidthPixels = (int) (newConfig.screenWidthDp * density);
        int newScreenHeightPixels = (int) (newConfig.screenHeightDp * density);

        // Get general orientation; either Configuration.ORIENTATION_PORTRAIT or
        // Configuration.ORIENTATION_LANDSCAPE.
        int newScreenOrientation = newConfig.orientation;

        // Get general rotation; one of: ROTATION_0, ROTATION_90, ROTATION_180,
        // or ROTATION_270.
        int newScreenRotation = getWindowManager().getDefaultDisplay()
                .getRotation();
    }




    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (EditText) findViewById(R.id.ed_txt_display);
        btn0 = (Button) findViewById(R.id.btn_0);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btnplus = (Button) findViewById(R.id.btn_plus);
        btnminus = (Button) findViewById(R.id.btn_minus);
        btnmultiply = (Button) findViewById(R.id.btn_multiply);
        btndevide = (Button) findViewById(R.id.btn_devide);
        btnequal = (Button) findViewById(R.id.btn_equal);
        btnclear = (Button) findViewById(R.id.btn_clear);
        btndot = (Button) findViewById(R.id.btn_dot);

/*
try catch ,, method ke body k ander aur code k aupar lga ga

* */

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "0");
                }catch(Exception e){}

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    display.setText(display.getText() + "1");
                }catch(Exception e){}
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "2");
                }catch(Exception e){}
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "3");
                }catch(Exception e){}
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "4");
                }catch(Exception e){}
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "5");
                }catch(Exception e){}

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "6");
                }catch(Exception e){}
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "7");
                }catch (Exception e){}
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "8");
                }catch(Exception e){}
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + "9");
                }catch(Exception e){}
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText() + ".");
                }catch(Exception e){}
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    display.setText(display.getText() + "+");



                }catch (Exception e){}


            }
        });

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //try
                try {

                    display.setText(display.getText() + "-");
                    //catch
                }catch(Exception e){}
            }
        });

        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //try
                try {

                    display.setText(display.getText() + "*");


                    //catch
                }catch(Exception e){}
            }
        });

        btndevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //try
                try {
                    display.setText(display.getText() + "/");
                    //catch
                }catch(Exception e){}
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //try
                try {

                    // yehan pa expj4 lgao



// yahen pa display sa values le aur aunhain String main convert kr wa dia
                    ExpressionBuilder variable_of_expression_builder = new ExpressionBuilder(display.getText().toString() );

                    double res = variable_of_expression_builder.build().evaluate();
                    display.setText(String.valueOf(res));

                    //catch
                }catch(Exception e){}


            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText("");
                }catch(Exception e){}

            }
        });





    }

}