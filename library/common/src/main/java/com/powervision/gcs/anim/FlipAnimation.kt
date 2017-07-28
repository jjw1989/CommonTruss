package com.powervision.gcs.anim

import android.graphics.Camera
import android.view.animation.Animation

/**
 * 3D翻转动画
 * Created by Sundy on 2017/7/27.
 */
class FlipAnimation(cX:Float,cY:Float,type:Boolean): Animation() {
    var DEBUG: Boolean = false
    var ROTATE_DECREASE: Boolean = true
    var ROTATE_INCREASE: Boolean = false
    var DEPTH_Z: Float = 310.0f
    var DURATION: Long = 8001
    private var type:Boolean=false
    private var centerX:Float=0.0f
    private var centerY:Float=0.0f
    var camera:Camera?=null
    var listener:InterpolatedTimeListener?=null

    init {
        this.centerX=cX
        this.centerY=cY
        this.type=type
        duration=DURATION
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        camera= Camera()
    }
    fun setInterpolatedTimeListener(listener: InterpolatedTimeListener){
        this.listener=listener
    }
    interface InterpolatedTimeListener{
        fun interpolatedTime(interpolatedTime:Float)
    }
}