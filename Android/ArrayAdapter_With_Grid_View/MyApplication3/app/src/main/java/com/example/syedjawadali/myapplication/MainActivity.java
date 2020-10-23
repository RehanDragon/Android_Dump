package com.example.syedjawadali.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 GridView gridView ;
 String [] items = {"Apple" , "mango" , "Banana" , "beery" , "graps" , "watermallon"};
 Integer[] logo={R.drawable.i1,R.drawable.i1,R.drawable.i1,R.drawable.i1,R.drawable.i1,R.drawable.i1};
 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CustomAdapter adapter = new CustomAdapter(MainActivity.this,items,logo);
        gridView=(GridView)findViewById(R.id.grid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) gridView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, itemValue, Toast.LENGTH_SHORT).show();


            }
        });





    }
}


