package com.robot.toolsman.bean

import android.os.Parcel
import android.os.Parcelable

data class HomeInnerBean(
        var url: String?,
        var content: String?,
        var time: String?
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(url)
        writeString(content)
        writeString(time)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<HomeInnerBean> = object : Parcelable.Creator<HomeInnerBean> {
            override fun createFromParcel(source: Parcel): HomeInnerBean = HomeInnerBean(source)
            override fun newArray(size: Int): Array<HomeInnerBean?> = arrayOfNulls(size)
        }
    }
}
