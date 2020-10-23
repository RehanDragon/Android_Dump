package com.usmanisolutions.authentication_using_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


// mera pas msla Progress bar main a reha ha


public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail,inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup,btnLogin,btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        //Msla Yehan Pa tha , ager get current user null nai ha to ausa Main activity pa bejho ,
//        if (auth.getCurrentUser() != null) {
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            finish();
//        }

        // set the view now
        setContentView(R.layout.activity_login);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

      /*

     //  Sign up ke intent ke wejha sa error  a reha ha

      btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        */

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });












        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }



              //  progressBar.setVisibility(View.VISIBLE);



                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>()


                        {


                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.



                                //progressBar.setVisibility(View.GONE);




                                if (!   (task.isSuccessful()   )     ) {
                                    // there was an error
                                    if (password.length() < 6)


                                    {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    }
                                    else

                                        {

                                            Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                          }


                                }


                                else

                                    {



                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();





                                    }
                            }
                        });
            }
        });

        /*super.onCreate(savedInstanceState);

//Get Firebase auth instance



        // why we had put this here before setContentView(R.layout.activity_login);

        *//* we made this before setContentView(R.layout.activity_login)  because if we

        will not do this it will directly jump to main activity
        * *//*
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null)
        {

            // this is same as
           //*

            startActivity(new Intent(LoginActivity.this,MainActivity.class)   );

            //*
            Intent intent_from_login_for_auth= new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent_from_login_for_auth);
            finish();
        }

        setContentView(R.layout.activity_login);





        inputEmail=(EditText) findViewById(R.id.email);
        inputPassword=(EditText) findViewById(R.id.password);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        btnSignup=(Button) findViewById(R.id.btn_signup);
        btnLogin=(Button) findViewById(R.id.btn_login);
        btnReset=(Button) findViewById(R.id.btn_reset_password);


        // we get the firebase auth instance
        auth = FirebaseAuth.getInstance();


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // same as below   startActivity(new Intent(LoginActivity.this,SignupActivity.class));

                Intent inten_for_sign_up= new Intent(LoginActivity.this,SignupActivity.class);

                startActivity(inten_for_sign_up);



            }
        });



        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));

                Intent intent_for_reset = new Intent(LoginActivity.this,ResetPasswordActivity.class);
                startActivity(intent_for_reset);
            }
        });



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String email = inputEmail.getText().toString();




                final String password = inputPassword.getText().toString();


                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();

                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
               return;
                }




              progressBar.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);


                                if(!  (  task.isSuccessful()  ))
                                {
                                    if (password.length() < 6)

                                    {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    }
                                    else 
                                        {
                                            Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_SHORT).show();
                                        }



                                }

                                else
                                    {

                                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                    }





                            }
                        });

            }


        });


        Log.i("rehan", String.valueOf(btnLogin));
        */





        // mena ais ko  Sign up wala ko Sub sa nech  kr dia
        btnSignup.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)


            {
              //  startActivity(new Intent(LoginActivity.this, SignupActivity.class));




                // i used getApplicationContext() so it will decrease the risk of app crashing
                Intent i = new Intent(getApplicationContext(),SignupActivity.class);




                startActivity(i);


                finish();
            }


        });




    }
}
