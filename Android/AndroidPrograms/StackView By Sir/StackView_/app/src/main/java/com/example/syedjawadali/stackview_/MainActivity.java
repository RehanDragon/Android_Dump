package com.example.syedjawadali.stackview_;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StackView stackView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stackView =(StackView) findViewById(R.id.stackview);

        stackView.setInAnimation(this , android.R.animator.fade_in);
        stackView.setInAnimation(this , android.R.animator.fade_out);

        StackViewAdapter adapter = new StackViewAdapter(getstores() , R.layout.item)

    }

    private List<String> getstores(){
//drawable images k name hongy
        List<String> stores = new ArrayList<String>();
        stores.add("one");
        stores.add("two");
        stores.add("three");
        return stores;

    }
}

class StackViewAdapter extends ArrayAdapter{
    private List<String> Storelist ;
    private Context context ;
    private int itemlayout;

    public StackViewAdapter(List<String> stores, int resource , Context contx) {
        super(contx , resource  , stores);
        Storelist = stores;
    context = contx;
    itemlayout = resource;

    }

    @Override
    public int getCount() {
        return Storelist.size();
    }


    @Override
    public Object getItem(int position) {
        return Storelist.get(position);

    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = LayoutInflater.from(parent.getContext()).inflate(itemlayout, parent , false);

        }
        String store = Storelist.get(position);
        TextView storename = (TextView)convertView.findViewById(R.id.text);
        ImageView storeimage = (ImageView) convertView.findViewById(R.id.image);
        storename .setText(store);
        int resId = context.getResources().getIdentifier(store , "drawable" , context.getPackageName());
        storeimage.setImageResource(resId);
        return convertView;


    }
}
