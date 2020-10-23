package com.example.marksheetby_get_extra_put_extra_in_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed_text1,ed_text2,ed_text3,ed_text4,ed_text5,ed_text6,ed_text7;
    private Button result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    ed_text1= (EditText) findViewById(R.id.ed_txt_1);
    ed_text2= (EditText) findViewById(R.id.ed_txt_2);
    ed_text3= (EditText) findViewById(R.id.ed_txt_3);
    ed_text4= (EditText) findViewById(R.id.ed_txt_4);
    ed_text5= (EditText) findViewById(R.id.ed_txt_5);
    ed_text6= (EditText) findViewById(R.id.ed_txt_6);
    ed_text7=(EditText) findViewById(R.id.ed_txt_7);

    result =(Button) findViewById(R.id.btn_result);


    result.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //double s1= Double.parseDouble(sub1_marks.getText().toString());

            MarkSheet obj = new MarkSheet();
            double s1= Double.parseDouble(ed_text1.getText().toString());
            double s2= Double.parseDouble(ed_text2.getText().toString());
            double s3= Double.parseDouble(ed_text3.getText().toString());
            double s4= Double.parseDouble(ed_text4.getText().toString());
            double s5= Double.parseDouble(ed_text5.getText().toString());
            double s6= Double.parseDouble(ed_text6.getText().toString());
            double s7= Double.parseDouble(ed_text7.getText().toString());

            double obtain_marks = obj.total_marks(s1,s2,s3,s4,s5,s6,s7);
            double percentage = obj.percentage(obtain_marks);
            String grade = obj.Grade(percentage);


            Intent i = new Intent(getApplicationContext() , Result_Showing_Screen.class);

            //intent_to_go_to_new_screen.putExtra("result" ,c); // this was from previous program



            // here (i) is variable of my intent
        //    i.putExtra("result_obtain_marks",obtain_marks);
         //   i.putExtra("result_percentage",percentage);

//percent , obtain marks
            i.putExtra("result_obtain_marks",obtain_marks);
          i.putExtra("result_percentage",percentage);
            i.putExtra("result_grade",grade);


            startActivity(i);






        }
    });








    }
}

class MarkSheet
{

    double total_marks(double a,double b , double c , double d , double e , double f , double g)
    {

        return a+b+c+d+e+f+g;
    }

    double percentage(double p)
    {

        double per = (p*100)/700;
        return per;
    }


    String Grade(double /*calculation perform kr reha hain na tbhe yehan pa parameter k ander data type double main le ha*/  f)
    {
        String grade;

        if(f <=100 && f >=80.99999 )
        {
            grade = "A+";
        }

        else if(f <=79.99999 && f >= 70.99999)
        {
            grade="A";
        }

        else if(f<=69.99999 && f >=60.99999)
        {
            grade="B";
        }

        else if(f<=59.99999 && f>=50.99999)
        {

            grade= "C";
        }

        else if (f<=49.99999 && f>=40.99999)
        {
            grade ="D";
        }

        else if(f<=39.99999 && f>=30.99999)
        {
            grade = "E";
        }


        else {
            grade = "F";
        }


        return grade;
    }










}