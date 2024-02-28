package com.example.planet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.zip.Inflater;

//This  custom_adapter class will serve as a bridge between the array list
// of data and the list view or other adapter view widget.
public class custom_adapter extends ArrayAdapter<planet> {
    //using custom layout--> custom_adapter
    //using custom object--> extends ArrayAdapter<planet>
    /*
    Whenever you have any custom layouts you need to populate as
    done before AND i'm extending array adapter, not base adapter
    because i need to populate my custom model class and remember,
    whenever you have a model class,you need to store these(planet) object in an
    array list and not an array.
     */
    private ArrayList<planet>planetsArrayList;
    Context context;

    public custom_adapter(   ArrayList<planet> planetsArrayList,Context context) {
        super(context, R.layout.item_list_layout,planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context=context;
    }
/*
view holder class: used to cache reference to the views within an item layout,
so that they don't need to be repeatedly looked up during scrolling.
without a viewholder class, the adapter would need to find the view
by id every time it needs to access a view within the layout,which
can be expensive in terms of performance.
 */
 private static class MYViewHolder{
     TextView planetName;
     TextView moonCount;
     ImageView planetImg;
}
/*getView method is a part of our adapter class and is used to
  create and return a view for a specific item in the list.
 */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /*get the planet object for the current position.
        the get item method is a method inherited from the
        array adapter class and it's used to retrieve the data item,
         */
        planet planets =getItem(position);
        /*
        inflate layout
         */
        MYViewHolder myViewHolder;
        final View result;
        if(convertView==null){
            myViewHolder=new MYViewHolder();
            LayoutInflater inflater= LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_list_layout,parent,false);
            /*passing false means that the view will not be attached to the parent right
            away,which is usually the desired behavior when you are providing the view to an adapter.
            since we sre using a custom adapter and passing it the view to handle it,
            we use false.
             */
          // finding views:
            myViewHolder.planetName=(TextView) convertView.findViewById(R.id.textView);
            myViewHolder.moonCount=(TextView) convertView.findViewById(R.id.textView2);
            myViewHolder.planetImg=(ImageView) convertView.findViewById(R.id.imageView);
            result =convertView;
            convertView.setTag(myViewHolder);

        }else{
            //the view is recycled
            myViewHolder=(MYViewHolder) convertView.getTag();
            result= convertView;
        }
        //Getting the data from model class(planet)
        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImg.setImageResource(planets.getImage());
        return result;
    }
}
