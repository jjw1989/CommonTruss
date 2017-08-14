package com.powervision.gcs.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.powervision.gcs.R
import com.powervision.gcs.utils.LanguageUtils
import com.powervision.gcs.view.indicator.ViewControl
import kotlinx.android.synthetic.main.gcs_guide_layout.*

/**
 * 向导页面
 * Create by Sundy on 2017/8/8
 */
@Route(path = "/ui/GuideActivity")
class GuideActivity : AppCompatActivity(), ViewControl {

    private val img_zh = intArrayOf(R.mipmap.flight_guide_0_zh, R.mipmap.flight_guide_1_zh, R.mipmap.flight_guide_2_zh, R.mipmap.flight_guide_3_zh, R.mipmap.flight_guide_4_zh, R.mipmap.flight_guide_5_zh, R.mipmap.flight_guide_6_zh)
    private val img_en = intArrayOf(R.mipmap.flight_guide_0_en, R.mipmap.flight_guide_1_en, R.mipmap.flight_guide_2_en, R.mipmap.flight_guide_3_en, R.mipmap.flight_guide_4_en, R.mipmap.flight_guide_5_en, R.mipmap.flight_guide_6_en)
    var views: MutableList<Int>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gcs_guide_layout)
        setScreenArrts()
        addBannerView()
        initBannerView()
    }


    /**
     * 添加Banner View
     */
    private fun addBannerView() {
        views!!.add(R.layout.pv_banner_common_layout)
        views!!.add(R.layout.pv_banner_common_layout)
        views!!.add(R.layout.pv_banner_common_layout)
        views!!.add(R.layout.pv_banner_common_layout)
        views!!.add(R.layout.pv_banner_common_layout)
        views!!.add(R.layout.pv_banner_common_layout)
        views!!.add(R.layout.pv_banner_last_layout)

    }

    /**
     * 实例化Banner View
     */
    private fun initBannerView() {
        //设置view监听
        bannerView.setViewControl(this)
        bannerView.setShowIndicator(false)
                .setView(views!!)
                .init()
    }

    /**
     * 编辑item View
     */
    override fun setView(view: View, type: Int) {
        var img = view.findViewById<ImageView>(R.id.bannerImg)
        when (type) {
            0, 1, 2, 3, 4, 5 -> setViewStyle(img, type)
            6 -> setLastViewStyle(view, type)
        }
    }

    /**
     * 设置通用布局
     */
    fun setViewStyle(imageView: ImageView, position: Int) {
        if (LanguageUtils.getNatLanguage(applicationContext)) {
            Glide.with(applicationContext)
                    .load(img_zh[position])
                    .into(imageView)
        } else {
            Glide.with(applicationContext)
                    .load(img_en[position])
                    .into(imageView)
        }
    }

    /**
     * 设置特殊布局
     */
    fun setLastViewStyle(view: View, type: Int) {
        var imgGif = view.findViewById<ImageView>(R.id.imgGif)
        var imgBg = view.findViewById<ImageView>(R.id.bannerLastImg)
        var startBtn = view.findViewById<Button>(R.id.startBtn)
    }

    /**
     * 设置屏幕属性
     */
    fun setScreenArrts() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        window.decorView.setOnSystemUiVisibilityChangeListener {
            window.decorView.systemUiVisibility = 5895
            window.decorView.requestFocus()
        }
    }
}
