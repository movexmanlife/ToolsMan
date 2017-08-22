package com.robot.toolsman.ui.main

import com.robot.toolsman.base.MvpView

interface MainMvpView : MvpView {
    fun showUpdateTips(message : String)
}