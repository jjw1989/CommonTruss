package com.powervision.gcs.ui.fgt.fly

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import com.powervision.gcs.R
import com.powervision.gcs.base.BaseFragment
import kotlinx.android.synthetic.main.pv_camera_seting_layout.*

/**
 * 相机设置界面
 * Create by Sundy on 2017/9/15
 */
class PVCameraSetingFragment : BaseFragment() {
    /**
     * 接受上个界面的数据
     */
    override fun initData(bundle: Bundle?) {

    }

    /**
     * 绑定视图
     */
    override fun bindLayout(): Int {
       return R.layout.pv_camera_seting_layout
    }

    /**
     * 初始化view
     */
    override fun initView(savedInstanceState: Bundle?, view: View?) {

    }

    /**
     * 业务处理
     */
    override fun doBusiness() {

        setViewPager()
    }

    private fun setViewPager() {
        mViewPager.adapter = object : PagerAdapter() {
            override fun getCount(): Int {
                return 3
            }

            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view == `object`
            }

            override fun destroyItem(container: View, position: Int, `object`: Any) {
                (container as ViewPager).removeView(`object` as View)
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val view = View(context)
                if (position == 0) {
                    view.setBackgroundColor(Color.RED)
                } else if (position == 1) {
                    view.setBackgroundColor(Color.BLUE)
                }
                container.addView(view)
                return view
            }
        }
        navigationTabTop.setViewPager(mViewPager,0)
    }

    /**
     * 单击事件连续点击处理
     */
    override fun onWidgetClick(view: View) {

    }

}
