//THIS HAD BECOMED A DESASTER  DONT FOLLOW THIS


package com.usmanisolutions.firebase_login_and_registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// this is sign up page
public class MainActivity extends AppCompatActivity {

private EditText inputEmail,inputPassword;
private Button btnSignIn,btnSignup,btnResetPassword;
private ProgressBar progressBar;
private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        auth=FirebaseAuth.getInstance();

        btnSignIn=(Button) findViewById(R.id.sign_in_button);
        btnSignup=(Button) findViewById(R.id.sign_up_button);
        btnResetPassword=(Button) findViewById(R.id.button_reset_password);
        inputPassword=(EditText)findViewById(R.id.password);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        inputEmail=(EditText) findViewById(R.id.email);




        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ResetPasswordActivity.class));
            }
        });



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

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
                    Toast.makeText(MainActivity.this, "Enter email add", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                return;
                }

                if(password.length() <6)
                {
                    Toast.makeText(MainActivity.this, "Password too short", Toast.LENGTH_SHORT).show();

                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(MainActivity.this, "createUserWithEmail:onComplete :"+task.isSuccessful(), Toast.LENGTH_SHORT).show();

                           progressBar.setVisibility(View.GONE);

                           if(! ( task.isSuccessful()  ) )
                           {
                               Toast.makeText(MainActivity.this, "Authentication failed"+task.getException(), Toast.LENGTH_SHORT).show();
                           }

                           else
                               {
                                 //  Intent i = new Intent(MainActivity.this,LoginActivity.class);

                               startActivity(new Intent());
                               }

                            }
                        });
            }
        });



    }

}
