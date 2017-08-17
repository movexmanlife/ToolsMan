package com.robot.toolsman.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<T : MvpView> : Presenter<T> {

    var mvpView: T? = null
        private set
    private val compositeSubscription = CompositeDisposable()

    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null

        if (compositeSubscription?.isDisposed()) {
            compositeSubscription.dispose()
        }
    }

    val isViewAttached: Boolean
        get() = mvpView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    fun addSubscription(subs: Disposable) {
        compositeSubscription.add(subs)
    }

    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")

}