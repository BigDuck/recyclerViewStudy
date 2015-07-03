package com.example.wpj.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WPJ on 2015/7/3.
 */
public class StaggerAdapter extends MySimpleAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<Integer> mHeight;


    public StaggerAdapter(Context mContext, List<String> mDatas) {
        super(mContext,mDatas);
//        this.mContext = mContext;
//        this.mDatas = mDatas;
      //  mInflater=LayoutInflater.from(mContext);
        mHeight=new ArrayList<Integer>();
        for (int i = 0; i <mDatas.size() ; i++) {
            mHeight.add((int) (100+ Math.random()*300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
   ViewGroup.LayoutParams layoutParams=holder.itemView.getLayoutParams();
        layoutParams.height=mHeight.get(position);
        holder.itemView.setLayoutParams(layoutParams);
        holder.txt_something.setText(mDatas.get(position));
        setUpItemEvent(holder);

    }


}
