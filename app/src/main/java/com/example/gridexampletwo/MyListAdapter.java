package com.example.gridexampletwo;

import android.app.Activity;
import android.content.Context;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> myToy;
    ArrayList<Double> prices;
    ArrayList<Integer> pic;
    LayoutInflater inflter;


    public MyListAdapter(Context context, ArrayList<String> myToy, ArrayList<Double> prices, ArrayList<Integer> pic) {
        this.context = context;
        this.myToy = myToy;
        this.prices = prices;
        this.pic = pic;
        this.inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return myToy.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflter.inflate(R.layout.list_layout, null);
        TextView item = (TextView)   view.findViewById(R.id.listItem);
        TextView price = (TextView)   view.findViewById(R.id.listPrice);
        LinearLayout li = (LinearLayout) view.findViewById(R.id.my_layout);
        ImageView myImage = (ImageView) view.findViewById(R.id.listImage);
        if(i%2 == 0){
            li.setBackgroundColor(Color.rgb(255,204,255));
        } else
            li.setBackgroundColor(Color.rgb(204,255,204));

        item.setText(myToy.get(i));
        price.setText(prices.get(i)+"Tk");
       // Log.e("price", prices.get(i));
        myImage.setImageResource(pic.get(i));

        return view;
    }
}

