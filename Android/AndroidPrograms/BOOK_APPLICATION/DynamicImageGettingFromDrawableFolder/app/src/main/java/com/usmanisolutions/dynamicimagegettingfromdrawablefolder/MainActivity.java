package com.usmanisolutions.dynamicimagegettingfromdrawablefolder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
/*
No, Android does not allow subfolders under /res/drawable: Can the Android drawable directory contain subdirectories?

You can however, add all image files under /drawable and then access them programmatically via:

int drawableID = context.getResources().getIdentifier("drawableName", "drawable", getPackageName());
iv.setImageResource(drawableID);
Where drawableName is a name of the drawable file, i.e. myimage if image file is myimage.jpg.

The code above will get image resource with id R.drawable.drawableName.


* */
      //ImageView1
    ImageView ImgViewVariable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImgViewVariable=(ImageView) findViewById(R.id.ImageView1);

        int drawableID =(int) getApplication().getResources().getIdentifier("abc", "drawable", getPackageName());
         ImgViewVariable.setImageResource(drawableID);
    }
}