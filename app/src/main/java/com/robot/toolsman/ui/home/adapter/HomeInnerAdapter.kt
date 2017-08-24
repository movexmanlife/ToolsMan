package com.robot.toolsman.ui.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.robot.toolsman.R
import com.robot.toolsman.base.GlideApp
import com.robot.toolsman.bean.HomeInnerBean

class HomeInnerAdapter(var mContext: Context, var mDataList: List<HomeInnerBean>, var mOnItemClicker: OnItemClick?) : RecyclerView.Adapter<HomeInnerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        // var view = LayoutInflater.from(mContext).inflate(R.layout.item_home_inner, null)
        var view = View.inflate(mContext, R.layout.item_home_inner, null)
        return ViewHolder(view, mOnItemClicker)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var homeInnerBean = mDataList.get(position)

        with(holder) {
            if (!TextUtils.isEmpty(homeInnerBean.content)) {
                contentTv.text = homeInnerBean.content
            }
            if (!TextUtils.isEmpty(homeInnerBean.time)) {
                timeTv.text = homeInnerBean.time
            }

            GlideApp.with(mContext)
                    .load(homeInnerBean.url)
                    .placeholder(R.mipmap.ic_launcher)
                    .centerCrop()
                    .into(iconIv)
        }
    }

    inner class ViewHolder(var item: View, var onItemClick: OnItemClick?) : RecyclerView.ViewHolder(item), View.OnClickListener {
        @BindView(R.id.icon_iv)
        lateinit var iconIv: ImageView
        @BindView(R.id.content_tv)
        lateinit var contentTv: TextView
        @BindView(R.id.time_tv)
        lateinit var timeTv: TextView

        init {
            ButterKnife.bind(this, item)
            item.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            onItemClick?.onItemClick(v, getAdapterPosition(), mDataList.get(getAdapterPosition()))
        }
    }

    interface OnItemClick {
        /**
         * 列表点击事件
         *
         * @param view     view
         * @param position 位置
         */
        fun onItemClick(view: View, position: Int, homeInnerBean: HomeInnerBean)
    }
}