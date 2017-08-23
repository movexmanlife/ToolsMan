package com.robot.toolsman.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseFragment
import com.robot.toolsman.bean.InfoBean
import com.robot.toolsman.ui.home.adapter.InfoAdapter
import com.robot.toolsman.util.ToastUtil
import com.robot.toolsman.util.VersionUtil
import java.util.ArrayList

class HomeFragment : BaseFragment(), HomeMvpView {

    @BindView(R.id.recyclerView)
    lateinit var mRecyclerView: RecyclerView

    lateinit var mDatas: MutableList<Any>
    lateinit var infoAdapter: InfoAdapter
    lateinit var mHomePresenter: HomePresenter

    override val layout: Int
        get() = R.layout.fragment_home

    companion object {
        fun newInstance() : HomeFragment {
            var fragment = HomeFragment()
            var bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)
        initView()
        mHomePresenter = HomePresenter()
        mHomePresenter.attachView(this)
        return view
    }

    fun initView() {
        initData()
        initRecyclerView()
    }

    protected fun initData() {
        mDatas = ArrayList<Any>()
        val imageList = ArrayList<Any>()
        imageList.add("http://avatar.csdn.net/3/B/9/1_baiyuliang2013.jpg")
        imageList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=a22d53b052fbb2fb2b2b5f127f482043/ac345982b2b7d0a2f7375f70ccef76094a369a65.jpg")
        imageList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=57c485df7cec54e75eec1d1e893a9bfd/241f95cad1c8a786bfec42ef6009c93d71cf5008.jpg")
        imageList.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=f3f6ab70cc134954611eef64664f92dd/dcc451da81cb39db1bd474a7d7160924ab18302e.jpg")
        imageList.add("https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=71cd4229be014a909e3e41bd99763971/472309f7905298221dd4c458d0ca7bcb0b46d442.jpg")
        imageList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1564533037,3918553373&fm=116&gp=0.jpg")
        for (i in 1..5) {
            val info = InfoBean()
            info.setText("TEXTTEXTTEXTTEXTTEXTTEXTTEXTTEXT" + i)
            info.setImgList(imageList)
            mDatas.add(info)
        }
    }

    private fun initRecyclerView() {
        mRecyclerView.setLayoutManager(LinearLayoutManager(activity))
        infoAdapter = InfoAdapter(activity, mDatas)
        mRecyclerView.setAdapter(infoAdapter)
    }

    override fun showUpdateTips(message : String) {
        ToastUtil.showShort(message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mHomePresenter.detachView()
    }
}
