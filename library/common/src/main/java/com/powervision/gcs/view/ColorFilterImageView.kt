package com.powervision.gcs.view

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView

/**
 * 实现图像根据按下抬起动作变化颜色
 * Created by Sundy on 2017/9/4.
 */
class ColorFilterImageView : ImageView, View.OnTouchListener {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        setOnTouchListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.FROYO)
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event!!.action) {
        //按下时图片变灰
            MotionEvent.ACTION_DOWN -> setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
        // 手指离开或取消操作时恢复原色
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> setColorFilter(Color.TRANSPARENT)
        }
        return false
    }
}