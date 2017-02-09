package com.garr.pavelbobrovko.test;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by garr on 08.02.2017.
 */

public class Adapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private Context mCtx;

    private String[] names;
    private int[] images;

    public Adapter(Context _mCtx){
        mCtx=_mCtx;
        names=mCtx.getResources().getStringArray(R.array.names);
        images=new int[]{R.drawable.ic_emblem,R.drawable.ic_action_news,R.drawable.ic_action_calendar,
                R.drawable.ic_action_tablet, R.drawable.ic_action_teem,R.drawable.ic_action_photo,
                R.drawable.ic_action_tv, R.drawable.ic_action_tickets,R.drawable.ic_action_setings};

        lInflater=(LayoutInflater)mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {return null;}

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v= view;

            v=lInflater.inflate(R.layout.item,viewGroup,false);


        if (i==0){
            v=lInflater.inflate(R.layout.item_emblem,viewGroup,false);
            ImageView ivEmblem=(ImageView)v.findViewById(R.id.ivEmblem);
            ivEmblem.setImageResource(R.drawable.ic_emblem);
        }else {
        ImageView ivItem=(ImageView)v.findViewById(R.id.ivItem);
        ivItem.setImageResource(images[i]);

        TextView tvItem=(TextView)v.findViewById(R.id.tvItem);
        tvItem.setText(names[i]);
        }

        return v;
    }
}
