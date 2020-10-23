package com.us.signup_form_and_login_Form_with_sharedPreferences_and_Date_With_SQLliteOpenHelper_Connected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {

    EditText editText;
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);


        // this is my edit text on which i will try to apply animation on it ,animation on the text
        editText=(EditText) findViewById(R.id.editText);




        /*//Setting Animation here of our layout
        RelativeLayout animatedLayout = (RelativeLayout) findViewById(R.id.animated_layout_on_login);

        AnimationDrawable animationDrawable = *//*cast kra*//* (AnimationDrawable) *//*ScrollView ka jo variable ha wo aye ga*//* animatedLayout.getBackground();

        // now putting fade Duration On AnimationDrawable variable

        animationDrawable.setEnterFadeDuration(2000); // time for entring of one graidient time
        animationDrawable.setExitFadeDuration(4000); //  time for entring of one gradient time
        // now we will start our animation by start method
        animationDrawable.start();
// here animated background works become over*/

        // animation work start from here










        // now we will use the get intent which was used to
        // the note id that was passed to this activity from Account_page activity
        Intent intent = getIntent();

         noteId= intent.getIntExtra("noteId",-1);

        if(noteId != -1)
        {
            editText.setText(Account_page.notes.get(noteId));
        }

        else
            {
                Account_page.notes.add("");
                noteId = Account_page.notes.size()-1;
                Account_page.arrayAdapter.notifyDataSetChanged();
            }



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // char sequence is the content of the edit text

                Account_page.notes.set(noteId,String.valueOf(charSequence));
                Account_page.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(/*we are using package id in simple package name*/"com.us.signup_form_and_login_Form_with_sharedPreferences_and_Date_With_SQLliteOpenHelper_Connected",MODE_PRIVATE);

                /*we are creating a set*/

                HashSet<String> set = new HashSet<>(/*jo tumhare note wale activity ha ku k wehan pa notes mojude hain*/Account_page.notes);//we create our String from our array list then we saved it in shared preferences

                sharedPreferences.edit().putStringSet("notes",set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
