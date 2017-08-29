package com.powervision.gcs.ui.aty.set

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.powervision.gcs.R
import com.powervision.gcs.ui.ScreenUtils
import kotlinx.android.synthetic.main.pv_airplane_setting_layout.*


/**
 * 飞机设置界面
 * Create by Sundy on 2017/8/29
 */
@Route(path = "/set/plane")
class AirplaneSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pv_airplane_setting_layout)

        var screenUtils:ScreenUtils= ScreenUtils(this)
        screenUtils.setSizeWithBackground(rootView,1080,400)
    }
}
