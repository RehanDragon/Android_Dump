package com.pramod.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.login.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pramod.firebase.storage.DeviceStore;

public class SignUp extends AppCompatActivity {

    Button signUpBtn;
    EditText email;
    EditText password;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setUpFirebase();
        setupElements();
    }

    //for sign up
    void  signUpEmailPassword(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                handleSignUpResult(task);
            }
        });
    }


    void handleSignUpResult(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            // Sign up success, update UI with the signed-in user's information
            Log.d(Constants.TAG, "signInWithEmail:success");
            FirebaseUser user = firebaseAuth.getCurrentUser();
            navigateHomePage();
            DeviceStore.getInstance().storeCurrentDevice(getContentResolver());
        } else {
            // If sign up fails, display a message to the user.
            Log.w(Constants.TAG, "signUpWithEmail:failure", task.getException());
            Toast.makeText(getApplicationContext(), "Unable to sign up", Toast.LENGTH_SHORT).show();
        }
    }

    void navigateHomePage() {
        Intent intent = new Intent(getApplicationContext(), MainHomeActivity.class);
        startActivity(intent);
    }

    void setUpFirebase() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    void setupElements() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        signUpBtn = findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(view.getContext(), SignUp.class);
                //view.getContext().startActivity(intent);}
                signUpEmailPassword(email.getText().toString(), password.getText().toString());
            }
        });


    }

}
