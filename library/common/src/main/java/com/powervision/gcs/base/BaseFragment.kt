package com.powervision.gcs.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * fragment基类
 * Created by David on 2017/8/8.
 */
abstract class BaseFragment : Fragment(), IBaseView {
    private val STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN"
    /**
     * 当前Activity渲染的视图View
     */
    protected var contentView: View? = null
    /**
     * 上次点击时间
     */
    private var lastClick: Long = 0

    protected var mActivity: BaseActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            var isSupportHidden: Boolean = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN)
            var ft: FragmentTransaction = fragmentManager.beginTransaction()
            if (isSupportHidden) {
                ft.hide(this)
            } else {
                ft.show(this)
            }
            ft.commit()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retainInstance = true
        contentView = inflater!!.inflate(bindLayout(), null)
        return contentView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle: Bundle = arguments
        initData(bundle)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mActivity = activity as BaseActivity?
        initView(savedInstanceState!!, contentView!!)
        doBusiness()
    }

    /**
     * 判断是否快速点击
     */
    fun isFastClick(): Boolean {
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
        if (!isFastClick()) onWidgetClick(view!!)
    }

    /**
     * 视图销毁
     */
    override fun onDestroyView() {
        if (contentView != null) {
            (contentView!!.parent as ViewGroup).removeView(contentView)
        }
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * 状态保存
     */
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden)
    }
}