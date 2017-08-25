package com.robot.toolsman.http

import com.robot.toolsman.bean.Mydata
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DoubanApi {
    /**
     * https://api.douban.com/v2/event/list?loc=118172&start=0&count=50
     */
    /**
     * Android所有数据
     */
    @GET("https://api.douban.com/v2/event/list?start=0&count=50")
    fun getHomeList(@Query("loc") loc:String): Observable<Mydata>

/*    *//**
     * iOS所有数据
     *//*
    @GET("data/iOS/10/{page}")
    fun getiOSData(@Path("page") page:Int):Observable<JsonResult<List<FuckGoods>>>

    *//**
     * iOS所有数据
     *//*
    @GET("data/福利/10/{page}")
    fun getGirlData(@Path("page") page:Int):Observable<JsonResult<List<FuckGoods>>>


    *//**
     * 手气不错
     *//*

    @GET("random/data/{type}/1")
    fun getRandom(@Path("type") type:String):Observable<JsonResult<List<FuckGoods>>>*/
}