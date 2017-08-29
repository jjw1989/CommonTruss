package com.powervision.gcs.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View

/**
 * activity的基类
 * Created by David on 2017/8/8.
 */

abstract class BaseActivity : AppCompatActivity(), IBaseView {
    /**
     * 当前Activity渲染的视图View
     */
    var rootView: View? = null
    /**
     * 上次点击的时间
     */
    private var lastClick: Long = 0

    protected var mActivity: BaseActivity? = null

    var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        context = applicationContext
        var bundle: Bundle = intent.extras
        initData(bundle)
        setBaseView(bindLayout())
        initView(savedInstanceState!!, rootView!!)
        doBusiness()
    }

    protected fun setBaseView(@LayoutRes layoutId: Int) {
        rootView = LayoutInflater.from(this).inflate(layoutId, null)
        setContentView(rootView)
    }

    /**
     * 判断是否快速点击
     */
    private fun isFastClick(): Boolean {
        var now: Long = System.currentTimeMillis()
        if (now - lastClick >= 500) {
            lastClick = now
            return false
        }
        return true
    }

    /**
     * 事件关联
     */
    override fun onClick(view: View?) {
        if (!isFastClick())
            onWidgetClick(view!!)
    }
}
