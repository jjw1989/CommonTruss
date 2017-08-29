package com.powervision.gcs.base

import android.os.Bundle
import android.view.View

/**
 * Created by David on 2017/8/30.
 */
interface IBaseView :View.OnClickListener{
    /**
     * 初始化数据
     * @param bundle 传递过来的bundle
     */
    fun initData(bundle: Bundle)

    /**
     * 绑定布局
     */
    fun bindLayout():Int

    /**
     * 初始化view
     */
    fun initView(savedInstanceState :Bundle, view:View)

    /**
     * 业务操作
     */
    fun doBusiness()

    /**
     * 视图点击事件
     * @param view 设置监听的view
     */
    fun onWidgetClick(view: View)
}