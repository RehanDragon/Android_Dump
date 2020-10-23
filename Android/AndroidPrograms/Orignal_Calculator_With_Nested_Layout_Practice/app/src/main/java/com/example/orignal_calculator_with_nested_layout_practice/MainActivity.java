package com.example.orignal_calculator_with_nested_layout_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

        EditText display;
        Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnplus, btnminus, btnmultiply, btndevide, btnequal, btnclear, btndot;
        double Result1, Result2; // two temporary storages
        boolean Add, Sub, Mul, Div;




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

                            if (display == null) {
                                display.setText("");
                            } else {
                                Result1 = Double.parseDouble(display.getText() + "");
                                Add = true;
                                display.setText(null);
                            }
                        }catch (Exception e){}


                    }
                });

                btnminus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //try
                        try {
                            if (display == null) {
                                display.setText("");
                            } else {
                                Result1 = Double.parseDouble(display.getText() + "");
                                Sub = true;
                                display.setText(null);
                            }
                            //catch
                        }catch(Exception e){}
                    }
                });

                btnmultiply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //try
                        try {
                            if (display == null) {
                                display.setText("");

                            } else {
                                Result1 = Double.parseDouble(display.getText() + "");
                                Mul = true;
                                display.setText(null);
                            }
                            //catch
                        }catch(Exception e){}
                    }
                });

                btndevide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //try
                        try {
                            if (display == null) {
                                display.setText("");
                            } else {

                                Result1 = Double.parseDouble(display.getText() + "");
                                Div = true;
                                display.setText(null);
                            }
                            //catch
                        }catch(Exception e){}
                    }
                });

                btnequal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //try
                        try {

                            Result2 = Double.parseDouble(display.getText() + "");

                            // add aupar plus k button main true he hu wa ha

                            if (Add == true) {
                                display.setText(Result1 + Result2 + "");
                                Add = false;
                            } else if (Sub == true) {
                                display.setText(Result1 - Result2 + "");
                                Sub = false;
                            } else if (Mul == true) {
                                display.setText(Result1 * Result2 + "");
                                Mul = false;

                            } else if (Div == true) {
                                display.setText(Result1 / Result2 + "");
                                Div = false;
                            }

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
