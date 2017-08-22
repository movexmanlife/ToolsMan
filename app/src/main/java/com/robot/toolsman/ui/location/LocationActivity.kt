package com.robot.toolsman.ui.location

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseActivity
import com.robot.toolsman.util.ToastUtil
import com.robot.toolsman.util.VersionUtil

class LocationActivity : BaseActivity(), LocationMvpView {

    @BindView(R.id.recyclerView)
    lateinit var mRecyclerView : RecyclerView

    lateinit var mLocationPresenter: LocationPresenter

    override val layout: Int
        get() = R.layout.activity_location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()

        mLocationPresenter = LocationPresenter()
        mLocationPresenter.attachView(this)
    }

    fun initView() {
        showVersion()
    }

    override fun showVersion() {
    }

    override fun showUpdateTips(message : String) {
        ToastUtil.showShort(message)
    }

//    @OnClick(R.id.layout_update, R.id.layout_csdn, R.id.layout_github)
//    fun onClick(view : View) {
//        when (view.id) {
//            R.id.layout_update-> {
//                mLocationPresenter.update()
//            }
//            R.id.layout_csdn-> {
//
//            }
//            R.id.layout_github-> {
//
//            }
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        mLocationPresenter.detachView()
    }
}
