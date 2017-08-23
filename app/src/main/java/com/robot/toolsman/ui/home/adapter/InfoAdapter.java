package com.robot.toolsman.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.robot.toolsman.R;
import com.robot.toolsman.bean.InfoBean;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Object> mListDatas;

    public InfoAdapter(Context context, List<Object> listDatas) {
        this.mContext = context;
        this.mListDatas = listDatas;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.item_info, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        InfoBean infoBean = (InfoBean) mListDatas.get(position);//转换
        holder.tv.setText(infoBean.getText());//填充数据

        if (infoBean.getImgList() != null && infoBean.getImgList().size() > 0) {
            ImageAdapter imageAdapter = new ImageAdapter(mContext, infoBean.getImgList());
            holder.rv_grid.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            holder.rv_grid.setAdapter(imageAdapter);
            holder.rv_grid.setVisibility(View.VISIBLE);
        } else {
            holder.rv_grid.setVisibility(View.GONE);
        }

        holder.iv_z.setOnClickListener(new ViewClikListener(position, 1));//赞 viewtype=1代表赞点击事件
        holder.iv_pl.setOnClickListener(new ViewClikListener(position, 2));//评论 viewtype=2代表评论点击事件
    }

    @Override
    public int getItemCount() {
        return mListDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;//内容
        ImageView iv_z, iv_pl;//赞，评论
        RecyclerView rv_grid;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
            rv_grid = (RecyclerView) view.findViewById(R.id.rv_grid);
            iv_z = (ImageView) view.findViewById(R.id.iv_z);
            iv_pl = (ImageView) view.findViewById(R.id.iv_pl);
        }
    }

    /**
     * view的点击事件
     */
    class ViewClikListener implements View.OnClickListener {

        int position;
        int viewtype;

        public ViewClikListener(int position, int viewtype) {
            this.position = position;
            this.viewtype = viewtype;
        }

        @Override
        public void onClick(View v) {

        }
    }

}
