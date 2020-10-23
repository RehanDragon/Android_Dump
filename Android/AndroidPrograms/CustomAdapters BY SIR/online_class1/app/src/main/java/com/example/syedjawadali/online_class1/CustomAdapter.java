package com.example.syedjawadali.online_class1;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int[] images ;
   String names[];
   LayoutInflater inflater;

   public CustomAdapter(Context appcontext , String[] names , int[] images){

       this.context = appcontext;
       this.images = images;
       this.names = names;
       inflater = (LayoutInflater.from(appcontext));



   }
    @Override
    public int getCount() {
        return names.length;
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
       TextView name = (TextView)convertView.findViewById(R.id.name);
       ImageView image = (ImageView)convertView.findViewById(R.id.image);
       name.setText(names[position]);
       image.setImageResource(images[position]);




       return convertView;
    }
}
