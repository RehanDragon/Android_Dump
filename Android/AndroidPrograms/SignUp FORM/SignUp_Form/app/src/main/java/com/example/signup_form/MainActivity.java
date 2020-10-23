package com.example.signup_form;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {


    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                   // "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");



    private EditText Username,Email,Password;
    private Button SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Setting Animation here of our layout
        ScrollView animatedLayout = (ScrollView)findViewById(R.id.animated_layout);

        AnimationDrawable animationDrawable = /*cast kra*/ (AnimationDrawable) /*ScrollView ka jo variable ha wo aye ga*/ animatedLayout.getBackground();

        // now putting fade Duration On AnimationDrawable variable

        animationDrawable.setEnterFadeDuration(2000); // time for entring of one graidient time
        animationDrawable.setExitFadeDuration(4000); //  time for entring of one gradient time
        // now we will start our animation by start method
        animationDrawable.start();






    Username=(EditText) findViewById(R.id.Input_User_Name);

    Email=(EditText) findViewById(R.id.Input_Email_Address);

    Password=(EditText) findViewById(R.id.Input_Password);


    SignUp=(Button) findViewById(R.id.SignUp);


    SignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(validateEmail() && validatePassword() && validateUsername() )
            {

                Toast.makeText(getApplicationContext(),"Sign Up Success full",Toast.LENGTH_SHORT).show();

                return;
            }
            String input =" Password "+  Username.getText().toString();
            input=input+"\n";
            input="  Email ,"+input+Email.getText().toString();
            input=input+"\n";
            input=" Enter UserName ,"+input+Password.getText().toString();


            Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();

        }
    });

    }

private boolean validateEmail()
{

    /*You can use android.text.TextUtils.isEmpty() instead. This method also checks to see if the String is null and has been available since API level 1.

if (TextUtils.isEmpty(str)) {
    Log.d(TAG, "String is empty or null!");
}*/

    String emailInput = Email.getText().toString();

    if(emailInput.isEmpty())
    {
        Email.setError("Field cant be empty");
        return false;
    }

    else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
    {

        Email.setError("Please enter a valid email address");
        return false;
    }

    else{

        Email.setError(null);
        return true;
    }


}

private boolean validateUsername()
{
    String usernameInput=Username.getText().toString();

    if (usernameInput.isEmpty())
    {
        Username.setError("Field cant be empty");
        return false;
    }
    else if(usernameInput.length() > 15)
    {
        Username.setError("Username too long");
        return false;
    }
    else{
        Username.setError(null);
        return true;

    }


}




private boolean validatePassword(){

        String passwordInput = Password.getText().toString();

        if(passwordInput.isEmpty())
        {
            Password.setError("Field cant be empty");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches())
        {
            Password.setError("Password too weak ,at least 1 special character , minimum length 8 characters");
            return false;
        }
        else{
            Password.setError(null);
            return true;
        }
}








/*
else if(!PASSWORD_PATTERN.matcher((CharSequence) Password).matches())
    {
        return false;
    }

    else{
        Password.setError(null);
        return true;
    }
* */

}
