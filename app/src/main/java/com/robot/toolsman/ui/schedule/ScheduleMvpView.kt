package com.robot.toolsman.ui.schedule

import com.robot.toolsman.base.MvpView

interface ScheduleMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}