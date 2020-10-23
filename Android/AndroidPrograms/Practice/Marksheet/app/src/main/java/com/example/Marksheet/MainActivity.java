package com.example.Marksheet;
//lecture 32 : Marksheet App With Functions and classes
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText sub1,sub2;
    TextView obtain_marks,percentage,grade;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    sub1 = (EditText) findViewById(R.id.ed_txt_1);

    sub2 =(EditText) findViewById(R.id.ed_txt_2);

    obtain_marks = (TextView) findViewById(R.id.tex_Obtain_marks);
    percentage =(TextView) findViewById(R.id.tex_Percentage);
    grade = (TextView) findViewById(R.id.tex_Grade);


    button =(Button) findViewById(R.id.btn_RESULT);



    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            // getText to  lia kro yehan pa , yeha pa ku ghalte kr reha ho
            // text lo ga to aus he ka bad to calculation ho ge
            // text nai lo ga to calculation kis pa ho ge
            // application crash ho gye ge



            // sub1 jo k edit text ha aus sa input lo ya , text get to kro
            // sub 2 jo k edit text ha aus sa input lo ya , text get to kro
            double a = Double.parseDouble(sub1.getText().toString());
            double b = Double.parseDouble(sub2.getText().toString());

            MyFunctions obj = new MyFunctions();

           double obt_marks =  obj.ObtainMarks(a,b);

           obtain_marks.setText(String.valueOf(obt_marks));

           double pe= obj.per(obt_marks);

           percentage.setText(String.valueOf(pe));


           String grad_e = obj.grade(pe);

           grade.setText(String.valueOf(grad_e));




        }
    });





    }
}


class MyFunctions
{
    public  double ObtainMarks(double s1 , double s2)
    {
        double total=s1+s2;
        return total;
    }

    public double per(double p)
    {

        double percent= (p *100)/200;
        return percent;

    }


    public  String grade(double g)
    {
        String Grade= "F";

        if(g <=100 && g>=89)
        {
            Grade="A+";
        }

        else if(g<=79 && g>=70)
        {
            Grade ="A";

        }

        else{
            Grade ="F";
        }





        return Grade;
    }



}