package com.usmanisolutions.stack_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StackView stackView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stackView= (StackView) findViewById(R.id.stack_view);


        MainAdapter adapter = new MainAdapter(numberWord() , numberImage(),R.layout.item,MainActivity.this);

        stackView.setAdapter(adapter);



    }


    // we are making return type method of number word with genric class  of String class returntype
    private List<String> numberWord()
    {
// Over riding hue we ha humare pas yehan pa    ,, List  main sa
        List<String> word = new ArrayList<>();


        word.add("One");
        word.add("Two");
        word.add("Three");
        word.add("Four");

        return word;
    }

    private List<Integer> numberImage()

    {
        List<Integer> image = new ArrayList<>();

        image.add(R.drawable.one);
        image.add(R.drawable.two);
        image.add(R.drawable.three);
        image.add(R.drawable.four);
        image.add(R.drawable.five);

        return image;
    }
}
