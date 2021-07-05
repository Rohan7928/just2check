package com.example.firstproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.firstproject.R;

public class MyAdapter extends BaseAdapter {
    String[] festivals_Values;
    Context context;

    public MyAdapter(Context mainActivity2, String[] festivals)
    {
        this.context=mainActivity2;
        this.festivals_Values=festivals;
    }

    @Override
    public int getCount() {
        return festivals_Values.length;
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
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_item,parent,false);

        TextView textView=view.findViewById(R.id.txt_listname);
       //ImageView imageView=view.findViewById(R.id.img_listItem);

        textView.setText(festivals_Values[position]);
        return view;
    }
}
   /* The LayoutInflater class is used to instantiate the contents of layout XML files
   into their corresponding View objects.
   In other words, it takes an XML file as input and builds the View objects from it.
    */