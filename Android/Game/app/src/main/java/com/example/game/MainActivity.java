package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ivBOTTLE;
    private Random r = new Random();
    private int direction;
    private boolean spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBOTTLE = (ImageView) findViewById(R.id.bottle);

    }

    public void Spinner(View V){

        if (!spin){

            int Dir = r.nextInt(1800);
            float x = ivBOTTLE.getWidth()/2;
            float y = ivBOTTLE.getHeight()/2;

            Animation ani = new RotateAnimation(direction, Dir, x, y);
            ani.setDuration(2500);
            ani.setFillAfter(true);
            ani.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spin = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    spin = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            direction = Dir;
            ivBOTTLE.startAnimation(ani);


        }
    }
}
