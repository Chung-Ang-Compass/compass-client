package com.example.compass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

class PackageSaleGridViewAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Integer> packages;
    LayoutInflater inf;


    public PackageSaleGridViewAdapter(Context context, int layout, ArrayList<Integer> packages) {
        this.context = context;
        this.layout = layout;
        this.packages = packages;

        Log.v("KKT", "packages : " + packages);
        Log.v("KKT", Integer.toString(layout));

        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Object getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.v("KKT", "position : " + Integer.toString(position) + " packages : " + packages);

        if (convertView==null)
            convertView = inf.inflate(layout, null);

        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);

        Log.v("KKT", "packages.get(position) : " + packages.get(position));
        Log.v("KKT", "ImageView iv : " + iv);

        iv.setImageResource(packages.get(position));

        return convertView;
    }
}
