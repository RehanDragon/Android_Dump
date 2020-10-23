package com.example.listview_with_onitem_selected_listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.LV_1);



        String [] list_of_items ={"item 1","item 2","item 3","item 4","item 5","item 6","item 6","item 7","item 8","item 9","item 10","item 11"};


        ArrayAdapter<String> array_adapter_variable = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list_of_items);


        lv.setAdapter(array_adapter_variable);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String value= lv.getItemAtPosition(i).toString();

                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

            }
        });


    }





}
