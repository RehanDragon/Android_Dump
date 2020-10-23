package com.example.practice_;
//Rating Bar
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RatingBar rate ;
    private Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button) findViewById(R.id.btn);
       rate =  (RatingBar) findViewById(R.id.ratingbar);


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {



               // value k ander rating ko get krwaya  aur condition lga de

               // yehan pa rating ke values ko define kr reha hain condition k ande k ager aitne rating ha to Good ha ya Poor ha
               Float value = rate.getRating();
               if(value>= 2){

                   Toast.makeText(getApplicationContext(),"Good" , Toast.LENGTH_SHORT).show();

               }


           }
       });


    }
}
