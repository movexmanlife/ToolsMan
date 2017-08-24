package com.robot.toolsman.ui.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseFragment
import com.robot.toolsman.ui.about.AboutActivity
import com.robot.toolsman.util.ToastUtil
import com.robot.toolsman.util.VersionUtil

class MeFragment : BaseFragment(), MeMvpView {

    @BindView(R.id.me_version)
    lateinit var mMeVersion: TextView
    lateinit var mMePresenter: MePresenter

    override val layout: Int
        get() = R.layout.fragment_me

    companion object {
        fun newInstance() : MeFragment {
            var fragment = MeFragment()
            var bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)
        initView()
        mMePresenter = MePresenter()
        mMePresenter.attachView(this)
        return view
    }

    fun initView() {
        showVersion()
    }

    override fun showVersion() {
        mMeVersion.text = getString(R.string.version_name, VersionUtil.getVersionName(activity))
    }
    override fun showUpdateTips(message : String) {
        ToastUtil.showShort(message)
    }

    @OnClick(R.id.me_about_layout)
    fun onClick(view : View) {
        when (view.id) {
            R.id.me_about_layout-> {
                AboutActivity.start(activity)
            }
            R.id.layout_csdn-> {

            }
            R.id.layout_github-> {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mMePresenter.detachView()
    }
}
