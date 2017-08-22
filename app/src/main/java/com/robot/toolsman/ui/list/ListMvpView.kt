package com.robot.toolsman.ui.list

import com.robot.toolsman.base.MvpView

interface ListMvpView : MvpView {
    fun showUpdateTips(message : String)
}