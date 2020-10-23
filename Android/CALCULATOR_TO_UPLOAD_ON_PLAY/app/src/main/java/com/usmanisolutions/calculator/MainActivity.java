package com.usmanisolutions.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import net.objecthunter.exp4j.ExpressionBuilder;
public class MainActivity extends AppCompatActivity {
    EditText display;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnplus,btnminus,btnmultiply,btndevide,btnequal,btnclear,btndelete,btndot;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       MainActivity.this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        display = (EditText) findViewById(R.id.ed_txt_display);
        btn0=(Button)findViewById(R.id.btn_0);
        btn1=(Button)findViewById(R.id.btn_1);
        btn2=(Button)findViewById(R.id.btn_2);
        btn3=(Button)findViewById(R.id.btn_3);
        btn4=(Button)findViewById(R.id.btn_4);
        btn5=(Button)findViewById(R.id.btn_5);
        btn6=(Button)findViewById(R.id.btn_6);
        btn7=(Button)findViewById(R.id.btn_7);
        btn8=(Button)findViewById(R.id.btn_8);
        btn9=(Button)findViewById(R.id.btn_9);
        btnplus=(Button)findViewById(R.id.btn_plus);
        btnminus=(Button)findViewById(R.id.btn_minus);
        btnmultiply=(Button)findViewById(R.id.btn_multiply);
        btndevide=(Button)findViewById(R.id.btn_devide);
        btnequal=(Button)findViewById(R.id.btn_equal);
        btnclear=(Button)findViewById(R.id.btn_clear);
        btndelete=(Button)findViewById(R.id.btn_delete);
        btndot=(Button)findViewById(R.id.btn_dot);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(  display.getText()       /*.append(   display.getText()  )*/       .toString() + "0");
                }catch(Exception e){}
            }});
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    display.setText(display.getText().toString().trim() + "1");
                }catch(Exception e){}
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "2");
                }catch(Exception e){}
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "3");
                }catch(Exception e){}
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "4");
                }catch(Exception e){}
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "5");
                }catch(Exception e){}
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "6");
                }catch(Exception e){}
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "7");
                }catch (Exception e){}
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "8");
                }catch(Exception e){}
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "9");
                }catch(Exception e){}
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + ".");
                }catch(Exception e){}
            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "+");
                }catch (Exception e){}
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "-");
                }catch(Exception e){}
            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "*");
                }catch(Exception e){}
            }
        });
        btndevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText(display.getText().toString().trim() + "/");
                }catch(Exception e){}
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ExpressionBuilder variable_of_expression_builder = new ExpressionBuilder(display.getText().toString() );

                    double res = variable_of_expression_builder.build().evaluate();
                    display.setText(String.valueOf(res));
                }

                catch (Exception   DivideByZero /*DivideByZero*/){}
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    display.setText("");
                }catch(ArithmeticException e){}
                catch (Exception e){}

            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//display <-- this is my edit text
/*

String s=editText.getText().toString();
        s=s.substring(0,s.lenght()-1)
        editText.setText(s);

* */
try {

    //guide taken from stack over flow
    //link=https://stackoverflow.com/questions/26177743/delete-button-in-calculator
    String s = display.getText().toString();

    s = s.substring(/*int value begin index*/0, /*end value end index*/s.length() - 1);

    display.setText(s);
}catch(Exception e){}

            }
        });
    }
}