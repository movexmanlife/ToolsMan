package com.robot.toolsman.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseFragment
import com.robot.toolsman.util.ToastUtil

class ListFragment : BaseFragment(), ListMvpView {

    lateinit var mListPresenter: ListPresenter

    override val layout: Int
        get() = R.layout.fragment_list

    companion object {
        fun newInstance() : ListFragment {
            var fragment = ListFragment()
            var bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)
        mListPresenter = ListPresenter()
        mListPresenter.attachView(this)
        return view
    }

    fun initView() {
    }

    override fun showUpdateTips(message : String) {
        ToastUtil.showShort(message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mListPresenter.detachView()
    }
}
