package com.robot.toolsman

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        /**
         * 定义静态变量sContext
         */
        lateinit var sContext: Context

        /**
         * 定义静态方法
         */
        fun getContext(): Context {
            return sContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        sContext = this
    }
}