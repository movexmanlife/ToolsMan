package com.robot.toolsman.ui.me

import com.robot.toolsman.base.MvpView

interface MeMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}