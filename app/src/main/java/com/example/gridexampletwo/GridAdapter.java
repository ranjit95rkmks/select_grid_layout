package com.example.gridexampletwo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    public Context context;
    ArrayList<Toy> toys;

    public GridAdapter(Context context, ArrayList<Toy> toys) {
        this.context = context;
        this.toys = toys;
    }

    @Override
    public int getCount() {
        return toys.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       /* View myView = inflater.inflate(R.layout.grid_layout, null, true);
        ImageView myImage = (ImageView) myView.findViewById(R.id.my_image);
        TextView title = (TextView) myView.findViewById(R.id.title);
        TextView price = (TextView) myView.findViewById(R.id.toy_price);
        myImage.setImageResource(toys.get(position).getImage());
        title.setText(toys.get(position).getTitle());
        price.setText(String.valueOf(toys.get(position).getPrice()));
        return myView;*/
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_layout, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.my_image);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.price = (TextView) convertView.findViewById(R.id.toy_price);
            holder.isCheckBox = (ImageView) convertView.findViewById(R.id.checkbox);
            holder.border = (LinearLayout) convertView.findViewById(R.id.my_view);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        Toy toy = toys.get(position);
        holder.title.setText(toy.getTitle());
        holder.image.setImageResource(toy.getImage());
        holder.price.setText(String.valueOf(toy.getPrice()));

        if (toy.isSelected()) {
            holder.isCheckBox.setImageResource(R.drawable.checked);
            holder.border.setBackgroundResource(R.drawable.grid_row_border);
        }
        else {
            holder.isCheckBox.setImageResource(R.drawable.check);
            holder.border.setBackgroundColor(Color.WHITE);

        }

        return convertView;
    }

    public void updateRecords(ArrayList<Toy> users) {
        this.toys = users;
        notifyDataSetChanged();


    }

    class ViewHolder {
        ImageView image;
        TextView title;
        TextView price;
        ImageView isCheckBox;
        LinearLayout border;

    }
}