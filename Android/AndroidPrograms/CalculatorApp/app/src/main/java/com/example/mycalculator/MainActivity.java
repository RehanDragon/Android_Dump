package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAdd,btnSub,btnMul,btnDiv,btnEqual,btnDot;
    Button btnClear;
    EditText ed1;
    float Res1,Res2;// result 1 , result 2 , these are two temporary storages
    boolean Add,Sub,Mul,Div;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn4= (Button) findViewById(R.id.btn4);
        btn5= (Button) findViewById(R.id.btn5);
        btn6= (Button) findViewById(R.id.btn6);
        btn7= (Button) findViewById(R.id.btn7);
        btn8= (Button) findViewById(R.id.btn8);
        btn9= (Button) findViewById(R.id.btn9);
        btn0= (Button) findViewById(R.id.btn0);
        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnSub= (Button) findViewById(R.id.btnSub);
        btnMul= (Button) findViewById(R.id.btnMul);
        btnDiv= (Button) findViewById(R.id.btnDiv);
        btnEqual= (Button) findViewById(R.id.btnEqual);
        btnDot= (Button) findViewById(R.id.btnDot);
        btnClear= (Button) findViewById(R.id.btnClear);

        ed1 = (EditText) findViewById(R.id.editText);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"1");

            }
        });




        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"2");

            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"3");

            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"4");

            }
        });


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"5");

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"6");

            }
        });


        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"7");

            }
        });


        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"8");

            }
        });



        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"9");

            }
        });



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+"0");

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText(ed1.getText()+".");

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1 == null)
                {
                    ed1.setText("");
                }
                else
                    {
                        Res1= Float.parseFloat(ed1.getText()+"");
                        Add=true;
                        ed1.setText(null);
                    }




            }
        });


        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1 == null)
                {
                    ed1.setText("");
                }
                else
                {
                    Res1= Float.parseFloat(ed1.getText()+"");
                    Sub=true;
                    ed1.setText(null);
                }




            }
        });



        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1 == null)
                {
                    ed1.setText("");
                }
                else
                {
                    Res1= Float.parseFloat(ed1.getText()+"");
                    Mul=true;
                    ed1.setText(null);
                }




            }
        });



        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1 == null)
                {
                    ed1.setText("");
                }
                else
                {
                    // jaisa he hum button pa click kerta hain waisa he hum ausa result 1 main store kerlaita hain

                    Res1= Float.parseFloat(ed1.getText()+"");
                    Div=true;
                    ed1.setText(null);
                }




            }
        });



        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Res2= Float.parseFloat(ed1.getText()+"");


                if(Add==true)
                {
                    ed1.setText(Res1+Res2+"");
                    //Add aub false ho gye ga ku ka ,condition true ho gye add ke. to aub aur mazed add na kro
                    Add=false;
                }

                else if(Sub==true)
                {
                    ed1.setText(Res1-Res2+"");
                    //Sub aub false ho gye ga ku ka ,condition true ho gye substract ke. to aub aur mazed substract na kro
                    Sub=false;
                }


               else if(Mul==true)
                {
                    ed1.setText(Res1*Res2+"");
                    //Mul aub false ho gye ga ku ka ,condition true ho gye multiply ke. to aub aur mazed multiply na kro
                    Mul=false;
                }

                else if(Div==true)
                {
                    ed1.setText(Res1/Res2+"");
                    //Div aub false ho gye ga ku ka ,condition true ho gye devide ke. to aub aur mazed devide na kro
                    Div=false;
                }











            }
        });



        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
            }
        });











    }
}
