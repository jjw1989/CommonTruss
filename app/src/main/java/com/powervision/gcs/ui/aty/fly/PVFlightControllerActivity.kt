package com.powervision.gcs.ui.aty.fly

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.powervision.gcs.R

/**
 * 飞控主页
 * Create by Sundy on 2017/8/29
 */
@Route(path = "/aty/fly/flight")
class PVFlightControllerActivity : AppCompatActivity() {
    var view:View?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pv_fly_controller_manager_layout)
    }
}
