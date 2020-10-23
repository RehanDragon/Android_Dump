package com.example.login_form_implementing_toast;
// Lecture 31  Login Form Using Toast and Boolean
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,pass;
    Button   login;
    Boolean  verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.ed_txt_name);
        pass= (EditText) findViewById(R.id.ed_txt_pass);
        login = (Button) findViewById(R.id.login_button);


// every thing will be don on click of button so we will define our logic on button
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Now putting verification method in Boolean Verify Variable so that we ca eaisily apply if else

                verify  = verification(name.getText().toString() ,pass.getText().toString());


                if(verify==true)
                {
                    Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext() , "Login UnSuccessfull",Toast.LENGTH_SHORT).show();
                }



            }
        });






    }




    private Boolean verification(String name_enter , String pass_enter)
    {


        if(name_enter.equals("rehan") && pass_enter.equals(""))
        {
            return true;
        }
        // writing else here is not necassary it will automatically return false if the condition is false.
        return false;



    }




}
