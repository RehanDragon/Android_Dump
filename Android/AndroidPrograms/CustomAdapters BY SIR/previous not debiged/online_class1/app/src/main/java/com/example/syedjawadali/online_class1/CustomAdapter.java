package com.example.syedjawadali.online_class1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int[] image ;
    String[] name;

    public CustomAdapter(Context appcontet , String [] name , int[] image){

        this.context = appcontet;
        this.image= image;
        this.name = name;
        inflater = (LayoutInflater.from(appcontet));
    }


    LayoutInflater inflater;

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.list_item , null);
        TextView names = (TextView)convertView.findViewById(R.id.name);
        ImageView images = (ImageView) convertView.findViewById(R.id.image);
        names.setText(name[position]);
        images.setImageResource(image[position]);
        return convertView;

    }
}
