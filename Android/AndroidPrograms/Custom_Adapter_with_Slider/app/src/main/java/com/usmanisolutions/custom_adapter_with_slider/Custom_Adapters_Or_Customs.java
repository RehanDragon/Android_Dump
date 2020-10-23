package com.usmanisolutions.custom_adapter_with_slider;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_Adapters_Or_Customs extends BaseAdapter {

Context context;
int[] image;
String [] name;

LayoutInflater inflater;

public Custom_Adapters_Or_Customs(Context appcontent,String [] name,int[] image)
{
    this.context=appcontent;
    this.image=image;
    this.name=name;
    inflater=( LayoutInflater.from(appcontent) );

}

    @Override
    public int getCount() {
    // jo return type ha aus sa he respective return ho ga
        return name.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {


    convertView = inflater.inflate(R.layout.list_item,null);
        TextView names = (TextView)convertView.findViewById(R.id.name);
        ImageView images =(ImageView) convertView.findViewById(R.id.image);
        names.setText(name[position]);
        images.setImageResource(image[position]);

        return /*convertView*/convertView;
    }
}
