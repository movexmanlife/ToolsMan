package com.robot.toolsman.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.robot.toolsman.R;
import com.robot.toolsman.base.GlideApp;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Object> mListDatas;

    public ImageAdapter(Context context, List<Object> listDatas) {
        this.mContext = context;
        this.mListDatas = listDatas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_grid, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String url = (String) mListDatas.get(position);//转换

        GlideApp.with(mContext)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mListDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            iv = (ImageView) view.findViewById(R.id.iv);
            textView = (TextView) view.findViewById(R.id.tv);
        }
    }
}
