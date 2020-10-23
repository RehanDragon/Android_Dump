package com.usmanisolutions.pagecurleffectbookapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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

        pageCurlView=findViewById(R.id.pageCurlView);

        imageList = new ArrayList<>();
        imageList.add(R.drawable.abc);


            pageCurlView.setCurlView(imageList);
            pageCurlView.setCurlSpeed(600);





        //   getImageFromDrabable();
    }

/*
    void getImageFromDrabable()
    {
//        int res = getResources().getIdentifier("<com.usmanisolutions.pagecurleffectbookapplication>:drawable/abc", null, null);
        //int res = getResources().getIdentifier("<com.usmanisolutions.pagecurleffectbookapplication>:drawable", null, null);


       

    }
    */

}