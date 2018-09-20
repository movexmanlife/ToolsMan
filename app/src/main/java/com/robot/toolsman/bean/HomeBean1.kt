package com.robot.toolsman.bean

import android.os.Parcel
import android.os.Parcelable

data class HomeBean(
        val text: String?,
        val imgList: List<HomeInnerBean>?
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.createTypedArrayList(HomeInnerBean.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        // dfd99999gfdgfdg
        writeString(text)
        writeTypedList(imgList)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<HomeBean> = object : Parcelable.Creator<HomeBean> {
            override fun createFromParcel(source: Parcel): HomeBean = HomeBean(source)
            override fun newArray(size: Int): Array<HomeBean?> = arrayOfNulls(size)
        }
    }
}
