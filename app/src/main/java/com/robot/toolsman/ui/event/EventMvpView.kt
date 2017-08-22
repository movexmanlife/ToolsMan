package com.robot.toolsman.ui.event

import com.robot.toolsman.base.MvpView

interface EventMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}