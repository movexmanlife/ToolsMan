package com.robot.toolsman.ui.action

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseActivity
import com.robot.toolsman.ui.about.AboutMvpView
import com.robot.toolsman.util.ToastUtil
import com.robot.toolsman.util.VersionUtil

class ActionActivity : BaseActivity(), ActionMvpView {

    @BindView(R.id.tv_version)
    lateinit var mTvVersion : TextView
    @BindView(R.id.layout_update)
    lateinit var mLayoutUpdate : LinearLayout
    @BindView(R.id.layout_csdn)
    lateinit var mLayoutCsdn : LinearLayout
    @BindView(R.id.layout_github)
    lateinit var mLayoutGithub : LinearLayout

    lateinit var mActionPresenter: ActionPresenter

    override val layout: Int
        get() = R.layout.activity_action

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()

        mActionPresenter = ActionPresenter()
        mActionPresenter.attachView(this)
    }

    fun initView() {
        showVersion()
    }

    override fun showVersion() {
        mTvVersion.text = getString(R.string.version_name, VersionUtil.getVersionName(this))
    }

    override fun showUpdateTips(message : String) {
        ToastUtil.showShort(message)
    }

    @OnClick(R.id.layout_update, R.id.layout_csdn, R.id.layout_github)
    fun onClick(view : View) {
        when (view.id) {
            R.id.layout_update-> {
                mActionPresenter.update()
            }
            R.id.layout_csdn-> {

            }
            R.id.layout_github-> {

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mActionPresenter.detachView()
    }
}
