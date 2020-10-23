package com.us.signup_form_and_login_Form_with_sharedPreferences_and_Date_With_SQLliteOpenHelper_Connected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
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



    private static EditText Username,Email,Password,retype_password,FirstName,LastName;
    private Button SignUp;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    private Button loginNow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginNow=(Button) findViewById(R.id.Login);

        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(MainActivity.this,login.class);
                startActivity(i);



            }
        });









//Setting Animation here of our layout
        ScrollView animatedLayout = (ScrollView)findViewById(R.id.animated_layout);

        AnimationDrawable animationDrawable = /*cast kra*/ (AnimationDrawable) /*ScrollView ka jo variable ha wo aye ga*/ animatedLayout.getBackground();

        // now putting fade Duration On AnimationDrawable variable

        animationDrawable.setEnterFadeDuration(2000); // time for entring of one graidient time
        animationDrawable.setExitFadeDuration(4000); //  time for entring of one gradient time
        // now we will start our animation by start method
        animationDrawable.start();
// here animated background works become over





    Username=(EditText) findViewById(R.id.Input_User_Name);

    Email=(EditText) findViewById(R.id.Input_Email_Address);

    Password=(EditText) findViewById(R.id.Input_Password);


    SignUp=(Button) findViewById(R.id.SignUp);



        retype_password= (EditText) findViewById(R.id.Retype_Password);


        FirstName=(EditText) findViewById(R.id.Input_First_Name);
        LastName=(EditText) findViewById(R.id.Input_Last_Name);
        openHelper = new DatabaseOpenHelper(this);

     //   passwordChecker();





        //this is work for sign up button
    SignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            db=openHelper.getWritableDatabase();

                 boolean data_inputs = insertdata(   FirstName.getText().toString(),LastName.getText().toString(),Username.getText().toString(),Password.getText().toString(),Email.getText().toString() ) ;

            // we will put all of the methods over here that we had created so that they could return all at a time
            if(validateEmail() && validatePassword() && validateUsername()  && passwordChecker() && FirstName_AND_LAST_NAME_CHECKER() &&  data_inputs==true /* jo bhe method apply kera ha wo yehan pa return ho ga */ )
            {

                Toast.makeText(getApplicationContext(),"Sign Up Success full",Toast.LENGTH_SHORT).show();




                    Toast.makeText(getApplicationContext(), " content stored " , Toast.LENGTH_SHORT).show();




                return;
            }
            else
            {

                Toast.makeText(getApplicationContext() ," content not stored " , Toast.LENGTH_SHORT).show();
            }





            String input =" Password "+  Username.getText().toString();
            input=input+"\n";

            input="  Email ,"+input+Email.getText().toString();
            input=input+"\n";
            input=" Enter UserName ,"+input+Password.getText().toString();


            Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();


        }
    });



    // this is work for login button













    }


    public  boolean FirstName_AND_LAST_NAME_CHECKER()
    {

        String Fname= FirstName.getText().toString() ;

        String Lname=LastName.getText().toString() ;

        if (  Fname.isEmpty() && Lname.isEmpty() )

        {
            FirstName.setError(" Field can not be empty ");
            LastName.setError(" Field can not be empty ");

            return false;
        }



        else{

            FirstName.setError(null);
            LastName.setError(null);

            return true;
        }




    }


    private  boolean passwordChecker()
    {


String a =retype_password.getText().toString();
String b = Password.getText().toString();

        if( !        a .equals(    b    )   /*  main condition ghlat likha reha tha  tbhe  condition nai  chl rahe the , yehan pa not(!) operator ana chayia ha ,, yeha pa ya ya bol reha ha ager retype password password ka braber nai ha to return false kr wao  */  )
        {
            retype_password.setError(" Password do not match  ");
            return false;
        }



        else {
            retype_password.setError(null);
            return true;
        }



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







    public boolean insertdata(String fname , String lname   , String username , String pass, String email )
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseOpenHelper.COL_2,fname);
        contentValues.put(DatabaseOpenHelper.COL_3,lname);
        contentValues.put(DatabaseOpenHelper.COL_4,username);
        contentValues.put(DatabaseOpenHelper.COL_5,pass);
        contentValues.put(DatabaseOpenHelper.COL_6,email);


        long id  = db.insert(DatabaseOpenHelper.TABLE_NAME,null ,contentValues);


        if(id==-1)
        {
            /*  Database main indexing zero sa start hote ha    */


            /* ager jo value insert hue ha to aus ka index   -1 ka braber ha   to value ko false  m return kro    */




            /* by doing this i get the values stored */
            return false;





        }
        else
            return true;

/* aur ager tumhare pas value database ke index zero  pa ha to value true kr do aur jo
 value insert hue ha ausa return kr wa do database ka ander
*/



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
