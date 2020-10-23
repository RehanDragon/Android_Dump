package com.usmanisolutions.authentication_using_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText inputEmail;
    private Button btnReset,btnBack;
    private FirebaseAuth auth;
     private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        inputEmail=(EditText) findViewById(R.id.email);
        btnReset=(Button) findViewById(R.id.btn_reset_password);
        btnBack=(Button) findViewById(R.id.btn_back);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);


        auth=FirebaseAuth.getInstance();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= inputEmail.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(getApplication(), "Enter your registered email ", Toast.LENGTH_SHORT).show();
                    return;
                }
                //progress bar yehan pa ha ager msla ho to ye reha
                
                
                
            //    progressBar.setVisibility(View.VISIBLE);
                
                
                // authentication for password
                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {

                                    Toast.makeText(getApplicationContext(), "we had sent you reset your password!", Toast.LENGTH_SHORT).show();
                                }
                                else
                                    {

                                        Toast.makeText(getApplicationContext(), "Failed to reset email!", Toast.LENGTH_SHORT).show();
                                    }
                               // progressBar.setVisibility(View.GONE);
                            }
                        });
                
            }
        });
    }
}