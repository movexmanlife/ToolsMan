package com.robot.toolsman.ui.schedule

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseActivity
import com.robot.toolsman.bean.ScheduleBean
import com.robot.toolsman.ui.about.AboutActivity
import com.robot.toolsman.util.DateUtil
import com.robot.toolsman.util.ToastUtil
import com.robot.toolsman.util.VersionUtil

class ScheduleActivity : BaseActivity(), ScheduleMvpView {

    @BindView(R.id.schedule_date1_tv)
    lateinit var mScheduleDate1Tv: TextView
    @BindView(R.id.schedule_time1_tv)
    lateinit var mScheduleTime1Tv: TextView

    @BindView(R.id.schedule_date2_tv)
    lateinit var mScheduleDate2Tv: TextView
    @BindView(R.id.schedule_time2_tv)
    lateinit var mScheduleTime2Tv: TextView

    @BindView(R.id.schedule_date3_tv)
    lateinit var mScheduleDate3Tv: TextView
    @BindView(R.id.schedule_time3_tv)
    lateinit var mScheduleTime3Tv: TextView

    lateinit var mSchedulePresenter: SchedulePresenter
    lateinit var mScheduleBean: ScheduleBean

    companion object {
        val KEY_SCHEDULE_BEAN = "scheduleBean"

        fun start(context: Context, scheduleBean: ScheduleBean) {
            var intent = Intent(context, ScheduleActivity::class.java)
            intent.putExtra(KEY_SCHEDULE_BEAN, scheduleBean)
            context.startActivity(intent)
        }
    }

    override val layout: Int
        get() = R.layout.activity_schedule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.let {
            mScheduleBean = intent.getParcelableExtra(KEY_SCHEDULE_BEAN)
        }
        initView()

        mSchedulePresenter = SchedulePresenter()
        mSchedulePresenter.attachView(this)
    }

    fun initView() {
        showScheduleDetailTime()
    }

    private fun showScheduleDetailTime() {
        mScheduleBean?.let {
            if (!TextUtils.isEmpty(mScheduleBean.beginTime)) {
                var beginTime: String = mScheduleBean.beginTime!!
                mScheduleDate1Tv.text = DateUtil.getWeek(beginTime)
                mScheduleTime1Tv.text = beginTime.split(" ")[1]
            }

            if (!TextUtils.isEmpty(mScheduleBean.endTime)) {
                var endTime: String = mScheduleBean.endTime!!
                mScheduleDate2Tv.text = DateUtil.getWeek(endTime)
                mScheduleTime2Tv.text = endTime.split(" ")[1]
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mSchedulePresenter.detachView()
    }
}
