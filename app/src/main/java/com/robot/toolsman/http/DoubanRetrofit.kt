package com.robot.toolsman.http

import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by win10 on 2017/8/24.
 */
class DoubanRetrofit {
    lateinit var doubanService: DoubanApi

    companion object {
        var gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .serializeNulls()
                .create()
    }

    init {
        var httpClient = OkHttpClient.Builder()
        if (DoubanFactory.isDebug) {

        }
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        var client = httpClient.build()

        var builder = Retrofit.Builder()
        builder.baseUrl("https://api.douban.com")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
        var doubanRetrofit = builder.build()
        doubanService = doubanRetrofit.create(DoubanApi::class.java)
    }
}