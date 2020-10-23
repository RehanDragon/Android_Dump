package com.example.orientation_and_color_changing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.widget.RelativeLayout;
import android.widget.Toast;


/*Docks that helped


https://developer.android.com/guide/topics/resources/runtime-changes.html

* */
public class MainActivity extends AppCompatActivity {

    RelativeLayout lays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        lays= (RelativeLayout) findViewById(R.id.lays);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            //landscape = -----------   tircha
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            lays.setBackgroundColor(Color.RED);
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            //portrait = ||||||||||||||    sedha
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            lays.setBackgroundColor(Color.GREEN);
/*

SpannableString spannableString = new SpannableString("Hello World!");
ForegroundColorSpan foregroundSpan = new ForegroundColorSpan(Color.RED);
BackgroundColorSpan backgroundSpan = new BackgroundColorSpan(Color.YELLOW);
spannableString.setSpan(foregroundSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
spannableString.setSpan(backgroundSpan, 3, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);

 */



        }


    }
}
