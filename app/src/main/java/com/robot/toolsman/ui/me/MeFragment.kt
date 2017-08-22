package com.robot.toolsman.ui.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseFragment
import com.robot.toolsman.util.ToastUtil

class MeFragment : BaseFragment(), MeMvpView {

    lateinit var mMePresenter: MePresenter

    override val layout: Int
        get() = R.layout.fragment_home

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
        mMePresenter = MePresenter()
        mMePresenter.attachView(this)
        return view
    }

    fun initView() {
    }

    override fun showUpdateTips(message : String) {
        ToastUtil.showShort(message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mMePresenter.detachView()
    }
}
