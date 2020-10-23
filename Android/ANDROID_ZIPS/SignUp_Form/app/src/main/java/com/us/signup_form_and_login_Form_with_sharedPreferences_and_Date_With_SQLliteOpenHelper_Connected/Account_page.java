package com.us.signup_form_and_login_Form_with_sharedPreferences_and_Date_With_SQLliteOpenHelper_Connected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Account_page extends AppCompatActivity {

// array list to store our notes
    //by making notes static it can be accessed from any class or any where
 static   ArrayList<String> notes= new ArrayList<>();

ListView listView;
 static   ArrayAdapter arrayAdapter;


 //creating method for option menu



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,/*assining our add_note_menu to the parameter's variable of method which is menu here*/menu);


        return super.onCreateOptionsMenu(menu);
    }

    //now creating onOptionsSelected which tell what to do after items are selected


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);


         if(item.getItemId() == R.id.add_note)
         {
             Intent intent = new Intent(getApplicationContext(),NoteEditorActivity.class);

             startActivity(intent);
         return true;
         }
    return false;
    }

    // this is our default on create which is pre made when we make our empty activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);



/*this is the work for date*/

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);


/*this is the work for Notepad */


       listView= (ListView) findViewById(R.id.listView);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(/*we are using package id in simple package name*/"com.us.signup_form_and_login_Form_with_sharedPreferences_and_Date_With_SQLliteOpenHelper_Connected",MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes",null);

        if(set==null){
            notes.add("Example note");
        }
        else
            {
                notes = new ArrayList(/*basis , parameters, limits , are defined here*/set);
            }


       notes.add("Example note");

       /*account k jo page ha aus k ander simple list item ka sample sa humara notes ko aus ka pattern ka tareka sa allign krdo*/
         arrayAdapter = new ArrayAdapter(Account_page.this,
                                     android.R.layout.simple_list_item_1 ,notes);

        // jo humara list view ka variable ha aus pa hum apna adpter ka variable ko  set krain ga
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent I = new Intent(Account_page.this,NoteEditorActivity.class);

                I.putExtra("noteId",i);
                startActivity(I);

            }
        });


       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

               final int itemToDelete =i;
               new AlertDialog.Builder(Account_page.this )
                       .setIcon(android.R.drawable.ic_dialog_alert)
                       .setTitle("Are you sure")
                       .setMessage("Do you want to delet this note?")
                       .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                           @Override /*positive button is yes*/
                           public void onClick(DialogInterface dialogInterface, int i) {
                               notes.remove(itemToDelete);
                               arrayAdapter.notifyDataSetChanged();

                               // set is updated when the note is deleted
                               SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(/*we are using package id in simple package name*/"com.us.signup_form_and_login_Form_with_sharedPreferences_and_Date_With_SQLliteOpenHelper_Connected",MODE_PRIVATE);

                               /*we are creating a set*/

                               HashSet<String> set = new HashSet<>(/*jo tumhare note wale activity ha ku k wehan pa notes mojude hain*/Account_page.notes);//we create our String from our array list then we saved it in shared preferences

                               sharedPreferences.edit().putStringSet("notes",set).apply();


                           }
                       }).setNegativeButton("No",null)
                       .show();


               return true;
           }
       });


    }








}
