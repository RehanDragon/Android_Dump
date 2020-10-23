package com.pramod.firebase;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.app.NotificationChannel;


public class HomeActivity extends AppCompatActivity {

    TextView userText;
    TextView realtimeText;
    FirebaseDatabase database;
    Button saveBtn;
    EditText dbValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        database = FirebaseDatabase.getInstance();
        setupElements();
        displayUser();
        realtimeSync();

    }



    void setupElements() {
        userText = findViewById(R.id.userInfo);
        realtimeText = findViewById(R.id.realTimeDBValue);
        saveBtn = findViewById(R.id.saveBtn);
        dbValue = findViewById(R.id.dbValue);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = dbValue.getText().toString();
                writeToDatabase(text);
            }
        });

    }





    void displayUser() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String text = "Welcome " + user.getEmail();
            userText.setText(text);
        }
    }

    String DEMO_KEY = "demoKey";

    void writeToDatabase(String value) {
        DatabaseReference dbReference = database.getReference(DEMO_KEY);
        dbReference.setValue(value);
    }

    void realtimeSync() {
        DatabaseReference dbReference = database.getReference(DEMO_KEY);
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = String.valueOf(dataSnapshot.getValue());
                realtimeText.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
