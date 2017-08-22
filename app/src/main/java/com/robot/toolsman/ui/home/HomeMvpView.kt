package com.robot.toolsman.ui.home

import com.robot.toolsman.base.MvpView

interface HomeMvpView : MvpView {
    fun showUpdateTips(message : String)
}