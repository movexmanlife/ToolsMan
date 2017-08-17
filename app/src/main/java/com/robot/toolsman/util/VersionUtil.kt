package com.robot.toolsman.util

import android.content.Context

/**
 * Created by win10 on 2017/8/17.
 */
object VersionUtil {
    /**
     * 获取版本名称
     */
    fun getVersionName(context : Context) : String {
        var versionName = ""

        try {
            var packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            versionName = packageInfo.versionName
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return versionName
    }

    /**
     * 获取版本号
     */
    fun getVersionCode(context : Context) : Int {
        var versionCode = 0

        try {
            var packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            versionCode = packageInfo.versionCode
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return versionCode
    }

}