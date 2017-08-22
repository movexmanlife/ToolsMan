package com.robot.toolsman.util

import android.content.Context
import android.view.View
import com.robot.toolsman.R

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

/**
 * 从资源文件中获取drawable数组
 */
fun Context.getDrawableResFromResources(resArrayId : Int) : IntArray {
    var typedArray = this.resources.obtainTypedArray(resArrayId)
    var resIds = IntArray(typedArray.length())
    for (index in resIds.indices) {
        resIds[index] = typedArray.getResourceId(index, 0)
    }
    typedArray.recycle()

    return resIds
}