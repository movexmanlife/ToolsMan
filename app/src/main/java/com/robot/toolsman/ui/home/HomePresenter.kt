package com.robot.toolsman.ui.home

import com.robot.toolsman.base.BasePresenter
import com.robot.toolsman.http.DoubanFactory
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class HomePresenter : BasePresenter<HomeMvpView>() {
    override fun attachView(mvpView: HomeMvpView) {
        super.attachView(mvpView)
    }

    fun update() {
        checkViewAttached()
        addSubscription(DoubanFactory.getDoubanSingleton().getHomeList("2222")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { myData-> })
    }
}