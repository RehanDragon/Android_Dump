package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView  search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        search = (AutoCompleteTextView) findViewById(R.id.AutoText);


        String [] names = {"aaaaa","bbbbb","ccccc" , "ddddd"};


        /* Here we are making object of builtin Array adapter  class and it have all
        builtin  classes  and ids of list that we want  */

        /* here this reffers to current method in which we are in


         from this method we are fetching our array variable which we had  created

        *  */
        // here  adapter is my variable of ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this  ,android.R.layout.simple_list_item_1,names);


        // search is my auto complete  text view
        //we had set our auto complete text view on adapter
        search.setAdapter(adapter);



    }
}
