package com.robot.toolsman.util

import android.widget.Toast
import com.robot.toolsman.App

object ToastUtil {
    private var toast: Toast? = null
    /**
     * 短时间显示toast,在旧的toast未消失之前，新的不会产生
     */
    fun showShort(message: CharSequence) {
        toast ?: let {
            toast = Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT)
        }

        toast?.setText(message)
        toast?.setDuration(Toast.LENGTH_SHORT)
        toast?.show()
    }

    /**
     * 长时间显示toast,在旧的toast未消失之前，新的不会产生
     */
    fun showLong(message: Int) {
        toast ?: let {
            toast = Toast.makeText(App.getContext(), message, Toast.LENGTH_LONG)
        }

        toast?.setText(App.getContext().resources.getString(message))
        toast?.setDuration(Toast.LENGTH_LONG)
        toast?.show()
    }

    /**
     * 长时间显示toast,在旧的toast未消失之前，新的不会产生
     */
    fun showLong(message: CharSequence?) {
        toast ?: let {
            toast = Toast.makeText(App.getContext(), message, Toast.LENGTH_LONG)
        }

        toast?.setText(message)
        toast?.setDuration(Toast.LENGTH_LONG)
        toast?.show()
    }
}