package com.powervision.gcs.anim

import android.graphics.Camera
import android.graphics.Matrix
import android.view.animation.Animation
import android.view.animation.Transformation

/**
 * 3D翻转动画
 * Created by Sundy on 2017/7/27.
 */
class FlipAnimation(cX: Float, cY: Float, type: Boolean) : Animation() {
    /** 值为true时可明确查看动画的旋转方向。 */
    var DEBUG: Boolean = false
    /** 沿Y轴正方向看，数值减1时动画逆时针旋转。 */
    var ROTATE_DECREASE: Boolean = true
    /** 沿Y轴正方向看，数值减1时动画顺时针旋转。 */
    var ROTATE_INCREASE: Boolean = false
    /** Z轴上最大深度。 */
    var DEPTH_Z: Float = 310.0f
    /** 动画显示时长。 */
    var DURATION: Long = 800
    /** 图片翻转类型。 */
    private var type: Boolean = false
    private var centerX: Float = 0.0f
    private var centerY: Float = 0.0f
    var camera: Camera? = null
    /** 用于监听动画进度。当值过半时需更新txtNumber的内容。 */
    var listener: InterpolatedTimeListener? = null

    init {
        this.centerX = cX
        this.centerY = cY
        this.type = type
        duration = DURATION
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        // 在构造函数之后、getTransformation()之前调用本方法。
        super.initialize(width, height, parentWidth, parentHeight)
        camera = Camera()
    }

    fun setInterpolatedTimeListener(listener: InterpolatedTimeListener) {
        this.listener = listener
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        if (listener != null) {
            listener!!.interpolatedTime(interpolatedTime)
        }
        var from = 0.0f
        var to = 0.0f
        if (type == ROTATE_DECREASE) {
            from = 0.0f
            to = 180.0f
        } else if (type == ROTATE_INCREASE) {
            from = 360.0f
            to = 180.0f
        }

        var degree = from + (to - from) * interpolatedTime
        var overHalf = (interpolatedTime > 0.5f)
        if (overHalf) {
            // 翻转过半的情况下，为保证数字仍为可读的文字而非镜面效果的文字，需翻转180度。
            degree = degree - 180
        }
        var depth = (0.5f - Math.abs(interpolatedTime - 0.5f)) * DEPTH_Z
        var matrix: Matrix = t!!.matrix
        camera!!.save()
        camera!!.translate(0.0f, 0.0f, depth)
        camera!!.rotateY(degree)
        camera!!.getMatrix(matrix)
        camera!!.restore()
        if (DEBUG) {
            if (overHalf) {
                matrix.preTranslate(-centerX * 2, -centerY)
                matrix.postTranslate(centerX * 2, centerY)
            }
        } else {
            // 确保图片的翻转过程一直处于组件的中心点位置
            matrix.preTranslate(-centerX, -centerY)
            matrix.postTranslate(centerX, centerY)
        }
    }

    /** 动画进度监听器。 */
    interface InterpolatedTimeListener {
        fun interpolatedTime(interpolatedTime: Float)
    }
}