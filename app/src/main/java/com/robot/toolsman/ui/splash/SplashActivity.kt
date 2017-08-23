package com.robot.toolsman.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.robot.toolsman.R
import com.robot.toolsman.base.BaseActivity
import com.robot.toolsman.ui.about.AboutActivity
import com.robot.toolsman.ui.main.MainActivity
import com.robot.toolsman.util.visible

class SplashActivity : BaseActivity(), SplashMvpView {

    @BindView(R.id.splash_btn)
    lateinit var mSplashBtn: TextView
    @BindView(R.id.splash_image)
    lateinit var mSplashImage: ImageView

    lateinit var mSplashPresenter: SplashPresenter
    lateinit var mFadeInAnimation: Animation
    lateinit var mTimerHandler : Handler

    override
    val layout: Int
        get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mSplashPresenter = SplashPresenter()
        mSplashPresenter.attachView(this)
        mTimerHandler = Handler()

        initView()
    }

    fun initView() {
        splashImageFadeIn()
        mTimerHandler.postDelayed({
            gotoMainActivity()
        }, 3000)
    }

    private fun splashImageFadeIn() {
        mSplashImage.visible()
        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_image_fade_in);
        mFadeInAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                gotoMainActivity()
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
        mSplashImage.startAnimation(mFadeInAnimation)
    }

    @OnClick(R.id.splash_btn)
    fun onClick(view: View) {
        when (view.id) {
            R.id.splash_btn -> {
                mFadeInAnimation?.let {
                    mFadeInAnimation.hasEnded().let {
                        mFadeInAnimation.cancel()
                    }
                }
                gotoMainActivity()
            }
        }
    }

    private fun gotoMainActivity() {
        MainActivity.start(this)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        mSplashPresenter.detachView()
        mTimerHandler.removeCallbacksAndMessages(null)
    }
}
