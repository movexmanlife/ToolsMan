package com.robot.toolsman.http

/**
 * Created by win10 on 2017/8/24.
 */
class DoubanFactory {
    companion object {
        var isDebug:Boolean = true
        private lateinit var sDoubanSingleton : DoubanApi

        fun getDoubanSingleton() : DoubanApi {
            if (sDoubanSingleton == null) {
                synchronized(DoubanFactory::class.java) {
                    if (sDoubanSingleton == null) {
                        sDoubanSingleton = DoubanRetrofit().doubanService
                    }
                }
            }
            return sDoubanSingleton
        }
    }
}