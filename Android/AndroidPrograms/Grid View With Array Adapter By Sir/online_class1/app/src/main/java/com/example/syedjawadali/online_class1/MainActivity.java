package com.example.syedjawadali.online_class1;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

GridView gv;
ArrayAdapter arrayAdapter;
Integer[] images= {
        R.drawable.i1,
        R.drawable.i2,
        R.drawable.i3
};




String text[]={"1","2","3"};


    customadapter  c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv=(GridView)MainActivity.this.findViewById(R.id.gridview);

//arrayAdapter=(ArrayAdapter) findViewById(R.id.arrayAdapter)
//Guide Taken From https://abhiandroid.com/ui/gridview



        arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,text);


         c=  new customadapter(getApplicationContext(),images);

        gv.setAdapter(c);
        gv.setAdapter(arrayAdapter);

gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

String itemvalue=(String) gv.getItemAtPosition(position);



Log.i("rehan"/*jis chez sa fetch kr wana ha aus ka nam aye ga */, itemvalue /*jis chez ko debug krwana ha aye ga */);
        Toast.makeText(MainActivity.this, itemvalue, Toast.LENGTH_SHORT).show();

    }
});









    }

    }


