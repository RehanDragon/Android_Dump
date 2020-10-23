package com.usmanisolutions.custom_adapter_with_slider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterViewFlipper;

public class MainActivity extends AppCompatActivity {

    private AdapterViewFlipper flipper;
    int [] Images =
            {
                    R.drawable.i1,
                    R.drawable.i2,
                    R.drawable.i3
    };

    String Names[]={

            "Text for Slider 1",
            "Text for Slider 2",
            "Text for Slider 3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper= (AdapterViewFlipper)findViewById(R.id.flipper);

        Custom_Adapters_Or_Customs obj= new Custom_Adapters_Or_Customs(getApplicationContext(),Names,Images);

        flipper.setAdapter(obj);
        flipper.setFlipInterval(1000);
        flipper.setAutoStart(true);

    }
}
