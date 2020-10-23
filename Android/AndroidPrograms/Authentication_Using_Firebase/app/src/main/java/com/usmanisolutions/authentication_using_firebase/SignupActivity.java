package com.usmanisolutions.authentication_using_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity  {
    private EditText inputEmail,inputPassword,firstname,lastname,fathersname,/*retypeemail,*/retypepassword;
    private Button btnSignIn,btnSignup,btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private RadioGroup radioGroup;




    // Radio Buttons logic for male female and other switcher and selecting



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        auth=FirebaseAuth.getInstance();


        btnSignIn=(Button) findViewById(R.id.sign_in_button);
        btnSignup=(Button) findViewById(R.id.sign_up_button);
        btnResetPassword=(Button) findViewById(R.id.button_reset_password);
        inputPassword=(EditText)findViewById(R.id.password);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        inputEmail=(EditText) findViewById(R.id.email);

        firstname=(EditText) findViewById(R.id.first_name);
        lastname=(EditText) findViewById(R.id.last_name);
        fathersname=(EditText) findViewById(R.id.fathers_name);
        /*retypeemail=(EditText) findViewById(R.id.retype_email);*/
        retypepassword=(EditText) findViewById(R.id.retype_password);
        radioGroup=(RadioGroup) findViewById(R.id.radio_button_group);









        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this,ResetPasswordActivity.class));
            }
        });



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_to_Login_Screen = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(go_to_Login_Screen);
                finish();
            }
        });




        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*logics in input wala variable pa lagain ge*/
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String first_name=firstname.getText().toString().trim();
                String last_name = lastname.getText().toString().trim();
                String fathers_name = fathersname.getText().toString().trim();
                /*String retype_email = retypeemail.getText().toString().trim();*/
                String retype_password = retypepassword.getText().toString().trim();


                /*

It is simply a set of utility functions to do operations on String objects.
 In fact, the whole class doesn't have any instance fields or methods.
  Everything is static. Consider it like a container to group functions with a text-based semantic.
   Many of them could have been methods of a String inherited class or CharSequence inherited class. For example you can do:


TextUtils.indexOf(string, char)
which is the same of doing

string.indexOf(char);





one of the uses of textUtils is for example lets say you have a string "apple,banana,orange,pinapple,mango" which doesnt fit inside

 a given width it can be converted to "Apple, banana, 2 more".


* */

                if(TextUtils.isEmpty(email))
                {
                    inputEmail.setError("Enter email address");
                    //Toast.makeText(SignupActivity.this, "Enter email add", Toast.LENGTH_SHORT).show();
                    return;
                }

                /*if(! (retype_email.equals(email) )  )
                {
                    retypeemail.setError("Entered Email not match");
                   // Toast.makeText(SignupActivity.this, "Entered Email not match", Toast.LENGTH_SHORT).show();
                    return;
                }*/

                if (TextUtils.isEmpty(fathers_name))
                {
                    fathersname.setError("Enter Fathers name");
                  //  Toast.makeText(SignupActivity.this, "Enter Fathers name", Toast.LENGTH_SHORT).show();
                return;
                }

                if(TextUtils.isEmpty(last_name)    )
                {
                   lastname.setError("Enter last Name");
                   // Toast.makeText(SignupActivity.this, "Enter last Name", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(password/*jis variable pa hum na input store kr waya ha wo wala variable rekha ha */))
                {
                    inputPassword.setError("Enter password");
                   // Toast.makeText(SignupActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(! (retype_password.equals(password)  )   )
                {
                    retypepassword.setError("Password dont match");
                    //return nai likhain ga to application ka flow yehan pa a k ruk gye ga
                   // Toast.makeText(SignupActivity.this, "Password dont match", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(TextUtils.isEmpty(first_name))
                {
                    firstname.setError("Enter first name");
                    //Toast.makeText(SignupActivity.this, "Enter first name", Toast.LENGTH_SHORT).show();
                }

                if(password.length() <6)
                {
                   inputPassword.setError("Password too short");
                   // Toast.makeText(SignupActivity.this, "Password too short", Toast.LENGTH_SHORT).show();

                    return;
                }


                /*Validation for gender with radio button*/
                /*
                GUIDE TAKEN FOR RADIO BUTTON VALIDATION LOGIC
                https://www.youtube.com/watch?v=AOaYvRQMNSw
                * */

                /*
                getCheckedRadioButton() returns -1 if no radio button is checked


                shayad jesa Sir na btya tha k
                -1 sa pecha chla jata ha
                to phit 1 sa age a jata ho ga
                shayad yahe logic ho ge
                * */

                int radio_button_selected = radioGroup.getCheckedRadioButtonId();
                if (radio_button_selected==-1)
                {

                    Toast.makeText(SignupActivity.this, "You have not Selected any of the gender", Toast.LENGTH_SHORT).show();
                    return;
                }



                progressBar.setVisibility(View.VISIBLE);
/// yehan sa if start kro

                //YA CONDITION MENA BNAYE HA , YA CONDITION MARE HA MARE HA MARE HA ,,, YA CONDITION MENA BNAYE HA , YA CONDITION MARE HA MARE HA MARE HA  ,,,  YA CONDITION MENA BNAYE HA , YA CONDITION MARE HA MARE HA MARE HA  ,,, YA CONDITION MENA BNAYE HA , YA CONDITION MARE HA MARE HA MARE HA
                if(  (password.length() >= 6 /*ager password ke length 6 characters sa bare ha ya aus ka braber ha*/      )  &&  (    !(TextUtils.isEmpty(first_name)  )/*ager first name empty nai ha*/     )     &&        (   (retype_password.equals(password)  ) /*ager retype password jo likha ha wo braber ha password k */  )   &&      (  !( TextUtils.isEmpty(password)    ) /*ager password ke field empty nai ha*/      )     &&       (   !(TextUtils.isEmpty(last_name))   /*ager last name ke field empty nai ha*/          )       &&   (    !(TextUtils.isEmpty(fathers_name) ) /*ager fathers name ke fields empty nai hain*/        )       /*&&    (  retype_email.equals(email)  *//*ager retype email braber ha email k*//*) */ &&       (  !(TextUtils.isEmpty(email) )  /*ager email empty nai ha */   ) && (!/*ager radio button jo select kia ha wo -1 k braber nai ha to login kro */ (radio_button_selected==-1) )     )
//NESTED IF ARE REPLACED BY &&  ,,,, AND else if  IS REPLACED BY  ||  (OR)
                {

/*
        AGER if() MAIN MOJUDE SARE CONDITIONS TRUE HAIN TO HE AUTHENTICATION SUCCESSFULL KRO NAI TO NAI KRO
 */



                    // JUST TESTING OUR LOGIC MADE BY ME




                    auth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override

                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(SignupActivity.this, "createUserWithEmail:onComplete :"+task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                    progressBar.setVisibility(View.GONE);

                                    if(! ( task.isSuccessful()  ) )
                                    {
                                        Toast.makeText(SignupActivity.this, "Authentication failed"+task.getException(), Toast.LENGTH_SHORT).show();
                                    }

                                    else
                                    {

//wapsi main activity pa ja reha ha
                                        Intent i = new Intent(SignupActivity.this,LoginActivity.class);
                                        startActivity(i);
                                        //Toast.makeText(SignupActivity.this, "pakistan", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }); // yehan tak auth pa method apply ho reha ha



                }
               // AIS K NECHA auth wala code tha



            }
        });










    }





    @Override
    protected void onResume() {
        super.onResume();
    progressBar.setVisibility(View.GONE);
    }




/*validation for Radio button method*/
     /*void validation_for_gender_with_radio_button()
    {
        int radio_button_selected = radioGroup.getCheckedRadioButtonId();
        if (radio_button_selected==-1)
        {

             Toast.makeText(SignupActivity.this, "You have not Selected any of the gender", Toast.LENGTH_SHORT).show();
            return;
        }

    }*/



}
