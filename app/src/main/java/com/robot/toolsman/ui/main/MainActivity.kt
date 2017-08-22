package com.robot.toolsman.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseActivity
import com.robot.toolsman.base.BaseFragment
import com.robot.toolsman.ui.home.HomeFragment
import com.robot.toolsman.ui.list.ListFragment
import com.robot.toolsman.ui.me.MeFragment
import com.robot.toolsman.util.ToastUtil
import com.robot.toolsman.util.getDrawableResFromResources
import com.robot.toolsman.widget.CustomViewPager

class MainActivity : BaseActivity(), MainMvpView {

    @BindView(R.id.custom_view_pager)
    lateinit var mCustomViewPager : CustomViewPager
    @BindView(R.id.tab_layout)
    lateinit var mTabLayout : TabLayout

    private var mCurrPosition: Int = POSITION_HOME
    lateinit var mTabImgSel: IntArray
    lateinit var mMainPresenter: MainPresenter
    lateinit var mFragmentList: MutableList<BaseFragment>

    companion object {
        val KEY_CURRENT_POSITION = "currentPosition"
        val POSITION_HOME = 0
        val POSITION_LIST = 1
        val POSITION_ME = 2
        val TITLE_ARRAY = arrayOf(R.string.tab_home_text, R.string.tab_list_text, R.string.tab_me_text)

        fun start(context : Context) {
            var intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override val layout: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            mCurrPosition = savedInstanceState.getInt(KEY_CURRENT_POSITION, POSITION_HOME)
        }

        initData()
        initView()
        setListener()

        mMainPresenter = MainPresenter()
        mMainPresenter.attachView(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(KEY_CURRENT_POSITION, mCurrPosition)
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        mFragmentList = mutableListOf()
        mFragmentList.add(HomeFragment.newInstance())
        mFragmentList.add(ListFragment.newInstance())
        mFragmentList.add(MeFragment.newInstance())

        mTabImgSel = getDrawableResFromResources(R.array.tab_img_array)
        mCustomViewPager.adapter = MyTabAdapter(supportFragmentManager, mFragmentList)
        mCustomViewPager.offscreenPageLimit = mFragmentList.size
    }

    /**
     * 初始化View
     */
    private fun initView() {
        initTabLayout()
        switchTab(POSITION_HOME)
    }

    private fun setListener() {
        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                mCurrPosition = tab.position
                refreshTabItem(mCurrPosition)
            }

        })
    }

    private fun initTabLayout() {
        for (i in mTabImgSel.indices) {
            var tabItem = mTabLayout.newTab()
            tabItem.setTag(i)
            tabItem.setCustomView(createTabItem(i))
            mTabLayout.addTab(tabItem)
        }
    }

    /**
     * 创建一个TabItem
     */
    private fun createTabItem(position : Int) : View {
        var view = LayoutInflater.from(this).inflate(R.layout.item_tab, mTabLayout, false)
        (view.findViewById(R.id.tab_img) as ImageView).setImageResource(mTabImgSel[position])
        (view.findViewById(R.id.tab_txt) as TextView).setText(TITLE_ARRAY[position])
        return view
    }

    /**
     * 更新TabItem的状态
     */
    private fun refreshTabItem(position: Int) {
        for (i in mFragmentList.indices) {
            var tabItemView = mTabLayout.getTabAt(i)?.customView
            tabItemView?.isSelected = (if (position == i) true else false)
        }
        mCustomViewPager.setCurrentItem(position, false)
    }

    /**
     * 切换tab，会引起TabLayout.OnTabSelectedListener的调用
     * @param tabIndex
     */
    private fun switchTab(tabIndex : Int) {
        when (tabIndex) {
            POSITION_HOME,
            POSITION_LIST,
            POSITION_ME ->{
                mTabLayout.getTabAt(tabIndex)?.select()
            }
        }
    }

    override fun showUpdateTips(message : String) {
        ToastUtil.showShort(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.detachView()
    }

    class MyTabAdapter(fragmentManager: FragmentManager, var mFragments : List<BaseFragment>) : FragmentPagerAdapter(fragmentManager) {
        override fun getItem(position: Int): BaseFragment {
            return mFragments.get(position)
        }

        override fun getCount(): Int {
            return mFragments.size
        }
    }
}
