package com.robot.toolsman.ui.about

import com.robot.toolsman.base.MvpView

interface AboutMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}