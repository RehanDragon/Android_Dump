package com.pramod.firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final ImageView imgView = (ImageView) findViewById(R.id.imageView);
        Animation aniRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        imgView.startAnimation(aniRotate);
        //final Animation fade_an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);

        imgView.startAnimation(aniRotate);
        aniRotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // imgView.startAnimation(fade_an);
                finish();
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        setupFireBase();
    }

    FirebaseAuth firebaseAuth;

    void setupFireBase() {
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseAuth.getInstance();
    }


}
