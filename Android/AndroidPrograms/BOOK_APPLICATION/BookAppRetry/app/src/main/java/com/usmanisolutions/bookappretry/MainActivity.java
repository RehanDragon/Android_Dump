package com.usmanisolutions.bookappretry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;

public class MainActivity extends AppCompatActivity {
    PageCurlView pageCurlView;
    List<Integer> imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





            pageCurlView=findViewById(R.id.PAageCurlView);
            imageList = new ArrayList<Integer>(2);
            imageList.add(R.drawable.abc);


            pageCurlView.setCurlView(imageList);
             pageCurlView.setCurlSpeed(700);







    }
}