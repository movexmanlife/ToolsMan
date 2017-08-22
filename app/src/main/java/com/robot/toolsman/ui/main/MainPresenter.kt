package com.robot.toolsman.ui.main

import com.robot.toolsman.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainPresenter : BasePresenter<MainMvpView>() {
    override fun attachView(mvpView: MainMvpView) {
        super.attachView(mvpView)
    }

    fun update() {
        checkViewAttached()

        mockUpdate(2000, Consumer {
            mvpView?.showUpdateTips("已是最新版本");
        })
    }

    /**
     * 模拟更新成功
     */
    private fun mockUpdate(timeMillis : Long, consumer : Consumer<Long>) {
        Observable.create(ObservableOnSubscribe<Long> { emitter ->
            try {
                Thread.sleep(timeMillis)
                emitter.onNext(0L)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer)
    }
}