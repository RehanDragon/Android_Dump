// You need to debug it

package com.example.marksheetquickpractice;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
// datatype and then variable

    private EditText Entered_name,sub1_marks,sub2_marks,sub3_marks,sub4_marks;

    private Button Result_Generating;

    private TextView Obtain_marks , Percentage , Grade ,Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Entered_name =  (EditText)  findViewById(R.id.ed_txt_Name);

        sub1_marks = (EditText) findViewById(R.id.editText_s1);

        sub2_marks = (EditText) findViewById(R.id.editText_s2);

        sub3_marks = (EditText) findViewById(R.id.editText_s3);

        sub4_marks =  (EditText) findViewById(R.id.editText_s4);








        Result_Generating = (Button) findViewById(R.id.btn_Calculate_Result);


















        Obtain_marks =  (TextView) findViewById(R.id.textView_Obt_Marks);


        Percentage =  (TextView) findViewById(R.id.textView_Percent);

        Grade= (TextView) findViewById(R.id.textView_Grade);

        Name =   (TextView) findViewById(R.id.textView_Name);

        Result_Generating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // yehan pa values ko pehla parse aur get kr wain ga
                String n = Entered_name.getText().toString();

                double s1= Double.parseDouble(sub1_marks.getText().toString());

                double s2= Double.parseDouble(sub2_marks.getText().toString());

                double s3 = Double.parseDouble(sub3_marks.getText().toString());

                double s4= Double.parseDouble(sub4_marks.getText().toString() );


                 double obt_marks =  ObtainMarks(s1,s2,s3,s4);

                 double percentage = Percentage(obt_marks);

                 String Grades = Grade(percentage);


                 Name.setText(n);

                 Obtain_marks.setText(String.valueOf(obt_marks));
                 Percentage.setText(String.valueOf(percentage));
                 Grade.setText(String.valueOf(Grades));



            }
        });














    }


    // obtain marks ka aik method bne ga , aik percentage ka , aur aik grade ka

    private static double ObtainMarks(  double a, double b , double c , double d  )
    {

        return a+b+c+d;
    }

    private static double Percentage(double  p)
    {
        // 400 are my total marks

      double per =   ( p * 100 )/400;
    return per;
    }


    private static String Grade(double/*calculation perform kr reha hain na tbhe yehan pa parameter k ander data type double main le ha*/ f)
    {

        String grade;

        if(f <=100 && f >=80 )
        {
            grade = "A+";
        }

        else if(f <=79 && f >= 70)
        {
            grade="A";
        }

        else if(f<=69 && f >=60)
        {
            grade="B";
        }

        else if(f<=59 && f>=50)
        {

            grade= "C";
        }

        else if (f<=49 && f>=40)
        {
            grade ="D";
        }

        else if(f<=39 && f>=30)
        {
            grade = "E";
        }


        else {
            grade = "F";
        }


        return grade;



    }


}
