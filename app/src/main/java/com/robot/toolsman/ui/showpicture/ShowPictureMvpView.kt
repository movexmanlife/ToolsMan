package com.robot.toolsman.ui.showpicture

import com.robot.toolsman.base.MvpView

interface ShowPictureMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}