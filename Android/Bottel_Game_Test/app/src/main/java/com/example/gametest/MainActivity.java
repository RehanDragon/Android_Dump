package com.example.gametest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView CokeBottle ; /*this is my image view variable*/
    /*Random is a builtin class*/
    /*we are creating Random object over here*/

    private Random random = new Random();
    private int direction_of_bottle;
    private boolean spin_the_bottle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// finding view by id of image view

        CokeBottle = (ImageView) findViewById(R.id.bottle);


    }

    // Spinner is my spin method  which i had created
    public void Spinner(View v /*View is the builtin class  and i had given a parameter of (v)*/)
    {

        //applying  boolean
        if(!spin_the_bottle)
        {

            int duration_of_bottle_spin = random.nextInt(1800); // what is this
            float x_axis_width= CokeBottle.getWidth()/2;
            float y_axis_height = CokeBottle.getHeight()/2;


            //Animation is a builtin class we are making its object over here

            /*Over riding hue ve ha yehan pa , ku k Constructor RotateAnimation wale class ka lga ha

             */

            /*
            * Animation ke aik builtin class ha jo k Parent class ha
            *
            * aus k ander RotateAnimation ke child class ha jo call kr wae ha
            *
            * RotateAnimation ka aik constructor ha

         public RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)

            jo hum na apply kra ha

*/

            /*
             package android.view.animation;

import android.content.Context;
import android.util.AttributeSet;

public class RotateAnimation extends Animation {
    public RotateAnimation(Context context, AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    public RotateAnimation(float fromDegrees, float toDegrees) {
        throw new RuntimeException("Stub!");
    }

    public RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY) {
        throw new RuntimeException("Stub!");
    }

    public RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
        throw new RuntimeException("Stub!");
    }

    protected void applyTransformation(float interpolatedTime, Transformation t) {
        throw new RuntimeException("Stub!");
    }

    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        throw new RuntimeException("Stub!");
    }
}


          */









            Animation anim = new RotateAnimation(direction_of_bottle,duration_of_bottle_spin,x_axis_width,y_axis_height);

            // setDuration is the method in Animation Class
            anim.setDuration(1500);
            //setFillAfter is the method in Animation Class
            anim.setFillAfter(true);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spin_the_bottle=true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spin_the_bottle=false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });


            direction_of_bottle =duration_of_bottle_spin;

            CokeBottle.startAnimation(anim);



        }




    }







}