package com.robot.toolsman.ui.category

import com.robot.toolsman.base.MvpView

interface CategoryMvpView : MvpView {
    fun showVersion()
    fun showUpdateTips(message : String)
}