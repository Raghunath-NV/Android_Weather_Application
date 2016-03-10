package com.example.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Raghu on 3/1/16.
 */

public class PlaceAdapter extends ArrayAdapter {


    List<Place> mData;
    Context mContext;
    int resource;


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource,parent,false);
        }
        Place c=mData.get(position);
        TextView tv1= (TextView) convertView.findViewById(R.id.textView);
        tv1.setText(c.getCity().replace("_"," ")+", "+c.getState());
        return convertView;


    }

    public PlaceAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        mContext=context;
        this.resource=resource;
        mData=objects;
    }
}