package com.robot.toolsman.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * {title: "Fiesta 社交拉丁舞免费体验课", beginTime: "2017-08-06 19:00:00", endTime: "2017-10-29 22:30:00"}
 */
data class ScheduleBean(var title: String?,
                        var beginTime: String?,
                        var endTime: String?) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(title)
        writeString(beginTime)
        writeString(endTime)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ScheduleBean> = object : Parcelable.Creator<ScheduleBean> {
            override fun createFromParcel(source: Parcel): ScheduleBean = ScheduleBean(source)
            override fun newArray(size: Int): Array<ScheduleBean?> = arrayOfNulls(size)
        }
    }
}