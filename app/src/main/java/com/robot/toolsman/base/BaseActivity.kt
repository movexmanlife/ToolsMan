package com.robot.toolsman.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class BaseActivity : AppCompatActivity() {

    abstract val layout: Int
    private lateinit var mUnbinder : Unbinder;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        mUnbinder = ButterKnife.bind(this);
    }

    override fun onDestroy() {
        super.onDestroy()
        mUnbinder?.unbind()
    }
}
