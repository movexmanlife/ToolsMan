package com.robot.toolsman.ui.action

import com.robot.toolsman.base.MvpView

interface ActionMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}