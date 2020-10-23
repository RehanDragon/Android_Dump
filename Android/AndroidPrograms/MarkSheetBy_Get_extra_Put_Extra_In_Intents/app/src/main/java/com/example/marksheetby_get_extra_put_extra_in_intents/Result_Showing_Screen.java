package com.example.marksheetby_get_extra_put_extra_in_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result_Showing_Screen extends AppCompatActivity {

    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__showing__screen);

        /*
        *  result = (TextView) findViewById(R.id.result);


    double displaying_result =  getIntent().getDoubleExtra("result" ,0);

    double result_ = getIntent().getDoubleExtra("result",0);


    // what does this mean then
        // result.setText(result +"");
    result.setText(   String.valueOf(result_)   );
        *
        * */





    t1= (TextView) findViewById(R.id.textView);
        t2= (TextView) findViewById(R.id.textView2);
        t3= (TextView) findViewById(R.id.textView3);

       // double marks = getIntent().getDoubleExtra("result_obtain_marks",0);

        double marks_obtain = getIntent().getDoubleExtra("result_obtain_marks",0);

        t1.setText(String.valueOf(marks_obtain));





       // double per = getIntent().getDoubleExtra("result_percentage",0);

        double percent = getIntent().getDoubleExtra("result_percentage",0);

        t2.setText(String.valueOf(percent));








        String grade = getIntent().getStringExtra("result_grade");

        t3.setText(String.valueOf(grade));






    }
}
