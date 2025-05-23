package com.example.planets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {
    //arraylist used to create dynamic memory for various layouts
    private ArrayList<Planet> planetArrayList;
    Context context;

    public MyCustomAdapter( ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.item_list_layout,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }
//    View Holder Class:used to cache references to the views
//    within an item layout,so that they don't need to be
//    repeatedly looked up during scrolling

    public static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }
//    getView():used to create and return a view
//        for a specific item in the list

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1-Get the planet object for the current position
        Planet planet = getItem(position);
        //2-Inflate Layout:
        MyViewHolder myViewHolder;
        final View result;

        if(convertView==null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater =LayoutInflater.from(getContext());
            convertView =inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
            //3-Finding Views
            myViewHolder.planetName=(TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount=(TextView) convertView.findViewById(R.id.moon_count_text);
            myViewHolder.planetImg=(ImageView) convertView.findViewById(R.id.imageView);
            result=convertView;
            convertView.setTag(myViewHolder);
        }
        else {
            myViewHolder=(MyViewHolder) convertView.getTag();
            result=convertView;
        }
        //Getting the data from model class(Planet)
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());
        return result;
    }
}
