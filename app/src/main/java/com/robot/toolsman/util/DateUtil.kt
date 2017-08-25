package com.robot.toolsman.util

import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    /**
     * 根据日期获得星期几
     */
    fun getWeek(date: Date): String {
        var weeks = arrayOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
        var cal = Calendar.getInstance()
        cal.time = date
        var week_index = cal.get(Calendar.DAY_OF_WEEK) - 1
        if (week_index < 0) {
            week_index = 0
        }

        return weeks[week_index]
    }

    fun getWeek(strDate: String) : String {
        var date = strToDate(strDate)
        return if (date == null) "" else getWeek(date)
    }

    fun strToDate(strDate: String): Date? {
        var date: Date? = null
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        try {
            date = formatter.parse(strDate)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return date
    }
}