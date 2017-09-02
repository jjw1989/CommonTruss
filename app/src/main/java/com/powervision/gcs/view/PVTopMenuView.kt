package com.powervision.gcs.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.powervision.gcs.R

/**
 * 顶部视图
 * Created by David on 2017/8/31.
 */
class PVTopMenuView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init {
       View.inflate(context, R.layout.pv_topmenu_layout,this)
    }


}