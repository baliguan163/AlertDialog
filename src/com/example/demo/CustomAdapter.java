package com.example.demo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private List<ItemBean> items;
    private LayoutInflater inflater;
    
   //dftttttt日日日
    private ImageView image;
    private TextView text;

    public CustomAdapter(List<ItemBean> items, Context context) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=inflater.inflate(R.layout.custom_adapter,null);
            image= (ImageView) view.findViewById(R.id.id_image);
            text= (TextView) view.findViewById(R.id.id_text);
        }
        image.setImageResource(items.get(i).getImageId());
        text.setText(items.get(i).getMessage());
        return view;
    }
}
