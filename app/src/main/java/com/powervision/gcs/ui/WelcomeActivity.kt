package com.powervision.gcs.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.powervision.gcs.R
import com.powervision.gcs.base.BaseActivity

/**
 * 欢迎页面
 * Create by Sundy on 2017/8/8
 */
class WelcomeActivity : BaseActivity() {
    /**
     * 接收数据
     */
    override fun initData(bundle: Bundle?) {

    }

    /**
     * 绑定视图
     */
    override fun bindLayout(): Int {
        return R.layout.gcs_welcome_layout
    }

    /**
     * 实例化控件
     */
    override fun initView(savedInstanceState: Bundle?, view: View?) {

    }

    /**
     * 业务处理
     */
    override fun doBusiness() {
        setScreenArrts()
        Handler().postDelayed({
            //ARouter.getInstance().build("/set/plane").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
            ARouter.getInstance()
                    .build("/aty/fly/flight")
                    .withTransition(R.anim.push_right_in,R.anim.push_right_out)
                    .navigation()
        },3000)
    }

    override fun onWidgetClick(view: View) {

    }


}
