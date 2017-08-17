package com.robot.toolsman.base

interface Presenter<in V: MvpView> {
    fun attachView(mvpView : V)
    fun detachView()
}