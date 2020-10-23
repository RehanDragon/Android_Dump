package com.usmanisolutions.stack_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MainAdapter extends ArrayAdapter {


    List<String> numberWord;
    List<Integer> numberImage;

    Context c;

    int itemLayout;

    public MainAdapter(@NonNull List<String> word,List<Integer> image, int resource,Context context) {
        super(context, resource,word);

        numberWord=word;

        numberImage=image;

        itemLayout=resource;
        c=context;

    }

    @Override
    public int getCount() {
        return numberWord.size();

    }


    @Nullable
    @Override
    public Object getItem(int position) {
        return numberWord.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
        {

            convertView = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);



        }


        String word = numberWord.get(position);
        Integer image = numberImage.get(position);

        TextView textView = convertView.findViewById(R.id.text_view);
        ImageView imageView = convertView.findViewById(R.id.image_view);

        textView.setText(word);
        imageView.setImageResource(image);

        return convertView;




    }
}
