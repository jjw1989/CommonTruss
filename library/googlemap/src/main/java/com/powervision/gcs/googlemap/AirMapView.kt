package com.powervision.gcs.googlemap

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * google地图封装
 * Created by Sundy on 2017/7/27.
 */
class AirMapView :FrameLayout{
    init {
        inflaterView()
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * 初始化视图
     */
    private fun inflaterView() {

    }
}