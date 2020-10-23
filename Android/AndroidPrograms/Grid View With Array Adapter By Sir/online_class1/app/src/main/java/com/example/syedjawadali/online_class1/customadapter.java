package com.example.syedjawadali.online_class1;


import android.content.Context;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customadapter extends ArrayAdapter<String> {

    private  Context context;
    private String[] items;
    private Integer[] logo;




    public customadapter (Context context , String[] items , Integer[] logo) {
        super(context, R.layout.custom_layout /*, items*/);
        this.context = context ;
        //this.items = items;
        this.logo = logo;

    }
    public View getveiw(int position , View view , ViewGroup parent){


        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View page = inflater.inflate(R.layout.custom_layout , null , true);


        TextView tittle = (TextView)page.findViewById(R.id.textview);


        ImageView img = (ImageView)page.findViewById(R.id.imgview);


        tittle.setText(items[position]);


        img.setImageResource(logo[position]);
        return page;


    }



}
