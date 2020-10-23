package com.usmanisolutions.adapterviewflipper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    /*
    Contex aik tareka ka syatem handler ha

    jis ka pas contex ho ga wo resources  ko handel kera ga


    IN SIMPLE WORDS

    jaisa hum aik game khailta hain , gane wala game  jis pa gana a k  khatam hota ha

    aus ke bare ate ha to wo koi kam kerta ha

    * */


    Context context;
    int[] fruitImages;
    String[] fruitNames;
    LayoutInflater inflater;


    public CustomAdapter(Context applicationContext,String[] fruitNames,int[] fruitImages)
    {
        this.context =applicationContext;
        this.fruitImages=fruitImages;
        this.fruitNames=fruitNames;
        //yehan sa inflate kero
        inflater =(LayoutInflater.from(applicationContext));
    }




    @Override
    public int getCount() {
        return fruitNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view=inflater.inflate(R.layout.list_item,null);

        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruitImage);
        TextView fruitName = (TextView) view.findViewById(R.id.fruitName);



        fruitName.setText(fruitNames/*ya wala variable humare pas aishe class main mojude ha */[position]);

        fruitImage.setImageResource(fruitImages[position]);

        return view;
    }
}
