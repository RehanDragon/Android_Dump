package com.example.bottlegamefinaltry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ImageView bottle;
    private Random random = new Random();
    private int LastDirection;
    private boolean spinning;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   bottle = findViewById(R.id.bottle);

    }

    public void spinBottle(View v)
    {
        if(!spinning) {

            // first we need a direction where we want to point
            int newDirection = random.nextInt(1800);
            // we will tell it where we want to apin it
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;


            Animation rotate = new RotateAnimation(LastDirection, newDirection, pivotX, pivotY);

            rotate.setDuration(2500);
            rotate.setFillAfter(true);

            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    spinning = false;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });


            LastDirection = newDirection;
            bottle.startAnimation(rotate);

        }


    }




}
