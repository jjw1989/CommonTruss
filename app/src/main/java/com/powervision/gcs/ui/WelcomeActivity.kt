package com.powervision.gcs.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.powervision.gcs.R

/**
 * 欢迎页面
 * Create by Sundy on 2017/8/8
 */
class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gcs_welcome_layout)
        setScreenArrts()
        ARouter.getInstance().build("/ui/GuideActivity").navigation()
    }

    /**
     * 设置屏幕属性
     */
    fun setScreenArrts(){
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        window.decorView.setOnSystemUiVisibilityChangeListener {
            window.decorView.systemUiVisibility=5895
            window.decorView.requestFocus()
        }
    }
}
