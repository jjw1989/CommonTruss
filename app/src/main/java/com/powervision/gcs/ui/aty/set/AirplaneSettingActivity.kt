package com.powervision.gcs.ui.aty.set

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
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
      //  window.setBackgroundDrawableResource(android.R.color.transparent)
       // window.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);

        // ...but notify us that it happened.
        window.setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,WindowManager. LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);
        setContentView(R.layout.pv_airplane_setting_layout)
        var screenUtils:ScreenUtils= ScreenUtils(this)
        screenUtils.setSizeWithBackground(rootView,1000,screenUtils.screenHeight)
        setFinishOnTouchOutside(false)
        //window.decorView.setBackgroundColor(Color.TRANSPARENT)
         // window.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
//        var wm:WindowManager=windowManager
////        var display:Display=wm.defaultDisplay
       var params:WindowManager.LayoutParams=window.attributes
//        params.height=display.height/2
        //params.alpha=0.0f
      //  params.dimAmount=0.0f
        window.setGravity(Gravity.RIGHT)
        window.attributes=params

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (MotionEvent.ACTION_OUTSIDE == event!!.action) {
            finish()
            return true
        }
        return super.onTouchEvent(event)

    }
}
