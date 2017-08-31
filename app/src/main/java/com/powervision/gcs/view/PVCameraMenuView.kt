package com.powervision.gcs.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.powervision.gcs.R

/**
 * 相机菜单
 * Created by Sundy on 2017/8/31.
 */
class PVCameraMenuView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    init {
        View.inflate(context, R.layout.pv_camera_menu_layout,this)
    }
}