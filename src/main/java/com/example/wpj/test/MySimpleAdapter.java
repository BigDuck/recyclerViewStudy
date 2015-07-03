package com.example.wpj.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by WPJ on 2015/7/3.
 */
public class MySimpleAdapter extends RecyclerView.Adapter<MySimpleAdapter.MyViewHolder> {
    private LayoutInflater mInflater;
    protected List<String> mDatas;
    private Context mContext;

    //    回调事件接口
    public interface OnItemClickListener {
        void onItemClick(View view, int postition);

        void onItemLongClick(View view, int postition);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MySimpleAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    /**
     * 添加数据
     *
     * @param pos
     */
    public void addDat5a(int pos) {
        mDatas.add(pos, "insert one");
        notifyItemInserted(pos);
    }

    /**
     * 移除数据
     *
     * @param pos
     */
    public void remData(int pos) {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txt_something.setText(mDatas.get(position));
        setUpItemEvent(holder);

    }

    protected void setUpItemEvent(final MyViewHolder holder) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, layoutPosition);

                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();

                    onItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
                    return false;
                }
            });
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_something;

        public MyViewHolder(View view) {
            super(view);
            txt_something = (TextView) view.findViewById(R.id.txt_something);


        }

    }

}
