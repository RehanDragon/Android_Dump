package com.usmanisolutions.arrayadapterwithgridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapters extends ArrayAdapter<String> {

    private Context context;
    private int[] items;
    private int[] logo;

    public CustomAdapters(@NonNull Context context, int [] items_in_list    ,int[] logo) {
        super(context, R.layout.activity_custom_adapters  ,  items_in_list );
        this.context=context;
        this.items=items_in_list;
        this.logo=logo;
    }


    /*public CustomAdapters(@NonNull Context context, int resource, int textViewResourceId, list_of_number_of_Items) {
        super(context, resource, textViewResourceId, objects);
    }*/


    }

