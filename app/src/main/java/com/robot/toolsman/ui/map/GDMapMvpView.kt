package com.robot.toolsman.ui.map

import com.robot.toolsman.base.MvpView

interface GDMapMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}