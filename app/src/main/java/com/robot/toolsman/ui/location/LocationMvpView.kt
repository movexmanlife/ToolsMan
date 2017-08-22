package com.robot.toolsman.ui.location

import com.robot.toolsman.base.MvpView

interface LocationMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}