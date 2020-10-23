package com.example.makingloginformsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private   EditText name,pass;
  private   Button LOGIN;
  private   Boolean verify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);

        pass = (EditText)  findViewById(R.id.pass);

        LOGIN = (Button) findViewById(R.id.button);




        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verify = verification(name.getText().toString() ,pass.getText().toString()   );

                if(verify == true)
                {
                    Toast.makeText(getApplicationContext() , "Login Successfull" , Toast.LENGTH_SHORT).show();
                }
                else
                    {Toast.makeText(getApplicationContext(),"Login Unsuccesfull" ,Toast.LENGTH_SHORT).show();}

            }
        });







    }




    private Boolean verification( String name , String pass )
    {
        if (name.equals("rehan") || name.equals("Rehan") && pass.equals("123") )
        {
            return true;
        }

        return false;



    }





}
