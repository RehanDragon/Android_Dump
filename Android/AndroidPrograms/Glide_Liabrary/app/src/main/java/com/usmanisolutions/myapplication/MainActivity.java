package com.usmanisolutions.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView imageView,imageView2,imageView3,imageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.my_image_view);
        imageView2 = (ImageView) findViewById(R.id.my_image_view_2);
        imageView3 = (ImageView) findViewById(R.id.my_image_view_3);
        imageView4 = (ImageView) findViewById(R.id.my_image_view_4);

        Glide.with(this).load("image/*").into(imageView);
        /*Glide.with(this).load("image/*").into(imageView2);
        Glide.with(this).load("image/*").into(imageView3);
        Glide.with(this).load("image/*").into(imageView4);*/
    }

    //For a simple image list:
     public View getView(int position, View recycled, ViewGroup container) {
        final ImageView myImageView;
        if (recycled == null) {
            //View inflater = null;
            myImageView = (ImageView) getLayoutInflater().inflate(R.layout.image_inflated,container,false);
            //myImageView = (ImageView) inflater.inflate(R.layout.my_image_view, container, false);
        } else {
            myImageView = (ImageView) recycled;
        }

        String img = "image/*";

         View myFragment = null;
         Glide
                .with(myFragment)
                .load(img)
                .centerCrop()
                .into(myImageView);

        return myImageView;
    }

}
