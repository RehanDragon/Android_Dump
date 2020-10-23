package com.example.syedjawadali.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomAdapter  extends ArrayAdapter<String> {


     private Context context ;
     private String[] items ;
     private Integer[] logo;



    public CustomAdapter(Context context , String[] items , Integer[] logo) {
        super(context, R.layout.custom_layout , items);

    this.context = context;
    this.items = items;
    this.logo  = logo;


    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_layout , null , true);
        TextView tittle = (TextView)row.findViewById(R.id.text);
        ImageView img = (ImageView)row.findViewById(R.id.img);
        tittle.setText(items[position]);
        img.setImageResource(logo[position]);


        return row;
    }
}
