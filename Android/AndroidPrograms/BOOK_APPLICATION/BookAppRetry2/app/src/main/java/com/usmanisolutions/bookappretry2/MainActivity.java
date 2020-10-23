/*
GUIDE TAKEN
http://findnerd.com/list/view/Page-Curl-Effect-in-android/21757/

* */

package com.usmanisolutions.bookappretry2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.usmanisolutions.bookappretry2.R;

import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*  DONT MAKE THINGS GLOBAL   */

        /* yehan pa cast krna lazmi ha cast nai kro ga to error aye ga aur Android
         Tumhare Demagh ke Aise ke Taise Phair Da ga*/
        PageCurlView pageCurlView = (PageCurlView) findViewById(R.id.pagecurl_view);
        List<Integer> pages_id = new ArrayList<>();
        pages_id.add(R.drawable.abc);
        pages_id.add(R.drawable.cba);

        pageCurlView.setCurlView(pages_id);
        pageCurlView.setCurlSpeed(65);

        /*
        Intent intent = new Intent(MainActivity.this,View.class);
        startActivity(intent);
        */

        /*
//here we havent create a method inside a method , we had implemented a method inside a method

        TheButtonToClickOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */




    }
}