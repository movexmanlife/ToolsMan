package com.robot.toolsman.ui.home.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.robot.toolsman.R
import com.robot.toolsman.bean.HomeBean

class HomeListAdapter(var mContext: Context, var mDataList: List<HomeBean>, var mOnItemClicker: OnItemClick?) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = View.inflate(mContext, R.layout.item_home, null)
        return ViewHolder(view, mOnItemClicker)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var infoBean = mDataList.get(position)

        infoBean.imgList?.isNotEmpty()?.let {
            with(holder){
                if (it) {
                    val imageAdapter = HomeInnerAdapter(mContext, infoBean.imgList!!, null)
                    recyclerView.setLayoutManager(LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false))
                    recyclerView.setAdapter(imageAdapter)
                    recyclerView.setVisibility(View.VISIBLE)
                } else {
                    recyclerView.setVisibility(View.GONE)
                }
            }
        }
    }

    inner class ViewHolder(var item: View, var onItemClick: OnItemClick?) : RecyclerView.ViewHolder(item), View.OnClickListener {
        @BindView(R.id.tv)
        lateinit var contentTv: TextView // 内容
        @BindView(R.id.iv_z)
        lateinit var goodTv: ImageView // 赞
        @BindView(R.id.iv_pl)
        lateinit var commentTv:ImageView // 评论
        @BindView(R.id.rv_grid)
        lateinit var recyclerView: RecyclerView

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
        fun onItemClick(view: View, position: Int, homeBean: HomeBean)
    }
}