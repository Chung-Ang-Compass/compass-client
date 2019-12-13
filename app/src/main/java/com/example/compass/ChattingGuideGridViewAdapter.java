package com.example.compass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ChattingGuideGridViewAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Guide> guides;
    LayoutInflater inf;


    public ChattingGuideGridViewAdapter(Context context, int layout, List<Guide> guides) {
        this.context = context;
        this.layout = layout;
        this.guides = guides;
        Log.v("KKT", "guides : " + guides);
        Log.v("KKT", Integer.toString(layout));
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return guides.size();
    }

    @Override
    public Object getItem(int position) {
        return guides.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("KKT", "position : " + Integer.toString(position) + " guides : " + guides);

        if (convertView==null)
            convertView = inf.inflate(layout, null);

        TextView guideNameTV = convertView.findViewById(R.id.guide_name);
        TextView guideCityTV = convertView.findViewById(R.id.guide_city);
        TextView guideThemeTV = convertView.findViewById(R.id.guide_theme);

        guideNameTV.setText(guides.get(position).getName());
        guideCityTV.setText(guides.get(position).getCity());
        guideThemeTV.setText(guides.get(position).getTheme());

        return convertView;
    }
}
