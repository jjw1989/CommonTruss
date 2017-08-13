package com.powervision.gcs.anim

import android.animation.ObjectAnimator
import android.view.animation.*

/**
 * 动画封装
 * Created by Sundy on 2017/7/27.
 */
object BaseAnimView {
    var animDuration: Long = 1000
    private var transAnim: TranslateAnimation? = null
    private var alphaAnim: AlphaAnimation? = null
    private var rotateAnim: RotateAnimation? = null
    private var rotate3dAnim: FlipAnimation? = null
    private var scaleAnim: ScaleAnimation? = null
    private var objAnim: ObjectAnimator? = null

    /**
     * 从底部进入
     */
    fun slideFromBottom(inter: Interpolator?): Animation {
        transAnim = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        transAnim?.fillAfter = true
        transAnim?.duration = animDuration
        if (inter != null) {
            transAnim?.interpolator = inter
        }
        return transAnim!!
    }

    /**
     * 从底部退出
     */
    fun slideToBottom(inter: Interpolator?): Animation {
        transAnim = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 1.0f)
        transAnim?.fillAfter = true
        transAnim?.duration = animDuration
        if (inter != null) {
            transAnim?.interpolator = inter
        }
        return transAnim!!
    }

    /**
     * 从顶部进入
     */
    fun slideFromTop(inter: Interpolator?): Animation {
        transAnim = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        transAnim?.fillAfter = true
        transAnim?.duration = animDuration
        if (inter != null) {
            transAnim?.interpolator = inter
        }
        return transAnim!!
    }

    /**
     * 从顶部退出
     */
    fun slideToTop(inter: Interpolator?): Animation {
        transAnim = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, -1.0f)
        transAnim?.fillAfter = true
        transAnim?.duration = animDuration
        if (inter != null) {
            transAnim?.interpolator = inter
        }

        return transAnim!!
    }

    /**
     * 从左边进入
     */
    fun slideFromLeft(inter: Interpolator?): Animation {
        transAnim = TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        transAnim?.fillAfter = true
        transAnim?.duration = animDuration
        if (inter != null) {
            transAnim?.interpolator = inter
        }
        return transAnim!!
    }

    /**
     * 从左边退出
     */
    fun slideToLeft(inter: Interpolator?): Animation {
        transAnim = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        transAnim?.fillAfter = true
        transAnim?.duration = animDuration
        if (inter != null) {
            transAnim?.interpolator = inter
        }
        return transAnim!!
    }

    /**
     * 淡入
     */
    fun fadingIn(): Animation {
        alphaAnim = AlphaAnimation(0.0f, 1.0f)
        alphaAnim?.fillAfter = true
        alphaAnim?.duration = animDuration
        return alphaAnim!!
    }

    /**
     * 淡出
     */
    fun fadingOut(): Animation {
        alphaAnim = AlphaAnimation(1.0f, 0.0f)
        alphaAnim?.fillAfter = true
        alphaAnim?.duration = animDuration
        return alphaAnim!!
    }

    /**
     *翻转动画
     */
    fun rotate3DFromLeft(inter: Interpolator?): Animation {
        rotate3dAnim = FlipAnimation(384.0f, 640.0f, false)
        rotate3dAnim?.fillAfter = true
        rotate3dAnim?.duration = animDuration
        if (inter != null) {
            rotate3dAnim?.interpolator = inter
        }
        return rotate3dAnim!!
    }

    /**
     *翻转动画
     */
    fun rotate3DFromRight(inter: Interpolator?): Animation {
        rotate3dAnim = FlipAnimation(384.0f, 640.0f, true)
        rotate3dAnim?.fillAfter = true
        rotate3dAnim?.duration = animDuration
        if (inter != null) {
            rotate3dAnim?.interpolator = inter
        }
        return rotate3dAnim!!
    }

    /**
     * 左侧中心旋转进入
     */
    fun rotateLeftCenterIn(inter: Interpolator?): Animation {
        rotateAnim = RotateAnimation(-90.0f, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.5f)
        rotateAnim?.fillAfter = true
        rotateAnim?.duration = animDuration
        if (inter != null) {
            rotateAnim?.interpolator = inter
        }
        return rotateAnim!!
    }

    /**
     * 左侧中心旋转退出
     */
    fun rotateLeftCenterOut(inter: Interpolator?): Animation {
        rotateAnim = RotateAnimation(0.0f, 180f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.5f)
        rotateAnim?.fillAfter = true
        rotateAnim?.duration = animDuration
        if (inter != null) {
            rotateAnim?.interpolator = inter
        }
        return rotateAnim!!
    }

    /**
     * 左侧顶部旋转进入
     */
    fun rotateLeftTopIn(inter: Interpolator?): Animation {
        rotateAnim = RotateAnimation(-90.0f, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        rotateAnim?.fillAfter = true
        rotateAnim?.duration = animDuration
        if (inter != null) {
            rotateAnim?.interpolator = inter
        }
        return rotateAnim!!
    }

    /**
     * 左侧顶部旋转退出
     */
    fun rotateLeftTopOut(inter: Interpolator?): Animation {
        rotateAnim = RotateAnimation(0.0f, -90f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        rotateAnim?.fillAfter = true
        rotateAnim?.duration = animDuration
        if (inter != null) {
            rotateAnim?.interpolator = inter
        }
        return rotateAnim!!
    }

    /**
     * 从中心旋转进入
     */
    fun rotateCenterIn(inter: Interpolator?): Animation {
        rotateAnim = RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f)
        rotateAnim?.fillAfter = true
        rotateAnim?.duration = animDuration
        if (inter != null) {
            rotateAnim?.interpolator = inter
        }
        return rotateAnim!!
    }

    /**
     * 从中心旋转退出
     */
    fun rotateCenterOut(inter: Interpolator?): Animation {
        rotateAnim = RotateAnimation(0.0f, -360.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f)
        rotateAnim?.fillAfter = true
        rotateAnim?.duration = animDuration
        if (inter != null) {
            rotateAnim?.interpolator = inter
        }
        return rotateAnim!!
    }

    /**
     * 缩放变大
     */
    fun scaleBig(inter: Interpolator?): Animation {
        scaleAnim = ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f)
        scaleAnim?.fillAfter = true
        scaleAnim?.duration = animDuration
        if (inter != null) {
            scaleAnim?.interpolator = inter
        }
        return scaleAnim!!
    }

    /**
     * 缩放变小
     */
    fun scaleSmall(inter: Interpolator?): Animation {
        scaleAnim = ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f)
        scaleAnim?.fillAfter = true
        scaleAnim?.duration = animDuration
        if (inter != null) {
            scaleAnim?.interpolator = inter
        }
        return scaleAnim!!
    }

    /**
     * 左上角缩放变大
     */
    fun scaleBigLeftTop(inter: Interpolator?): Animation {
        scaleAnim = ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        scaleAnim?.fillAfter = true
        scaleAnim?.duration = animDuration
        if (inter != null) {
            scaleAnim?.interpolator = inter
        }
        return scaleAnim!!
    }

    /**
     * 缩小到左上角
     */
    fun scaleSmallLeftTop(inter: Interpolator?): Animation {
        scaleAnim = ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        scaleAnim?.fillAfter = true
        scaleAnim?.duration = animDuration
        if (inter != null) {
            scaleAnim?.interpolator = inter
        }
        return scaleAnim!!
    }

    /**
     * 水平放大
     */
    fun scaleToBigHorizontalIn(inter: Interpolator?): Animation {
        scaleAnim = ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.0f)
        scaleAnim?.fillAfter = true
        scaleAnim?.duration = animDuration
        if (inter != null) {
            scaleAnim?.interpolator = inter
        }
        return scaleAnim!!
    }

    /**
     * 水平缩小
     */
    fun scaleToBigHorizontalOut(inter: Interpolator?): Animation {
        scaleAnim = ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.0f)
        scaleAnim?.fillAfter = true
        scaleAnim?.duration = animDuration
        if (inter != null) {
            scaleAnim?.interpolator = inter
        }
        return scaleAnim!!
    }

    /**
     * 垂直放大
     */
    fun scaleToBigVerticalIn(inter: Interpolator?): Animation {
        scaleAnim = ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.5f)
        scaleAnim?.fillAfter = true
        scaleAnim?.duration = animDuration
        if (inter != null) {
            scaleAnim?.interpolator = inter
        }
        return scaleAnim!!
    }

    /**
     * 垂直缩小
     */
    fun scaleToBigVerticalOut(inter: Interpolator?): Animation {
        scaleAnim = ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.5f)
        scaleAnim?.fillAfter = true
        scaleAnim?.duration = animDuration
        if (inter != null) {
            scaleAnim?.interpolator = inter
        }
        return scaleAnim!!
    }

    /**
     * 摇动
     */
    fun shakeMode(inter: Interpolator?, shakeCount: Int): Animation {
        transAnim = TranslateAnimation(Animation.RELATIVE_TO_PARENT, -0.1f, Animation.RELATIVE_TO_PARENT, 0.1f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f)
        if (shakeCount == null) {
            transAnim?.repeatCount = 1
        } else {
            transAnim?.repeatCount = shakeCount
        }
        transAnim?.duration = 400
        if (inter != null) {
            transAnim?.interpolator = inter
        } else {
            transAnim?.interpolator = BaseEffects.bounInter
        }
        return transAnim!!
    }

    /*********************************************************************/
    fun slideFromRight(inter: Interpolator?): Animation {
        transAnim=TranslateAnimation(Animation.RELATIVE_TO_PARENT,1.0f,Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,0.0f)
        transAnim?.fillAfter=true
        transAnim?.duration= animDuration
        if (inter!=null){
            transAnim?.interpolator=inter
        }
        return transAnim!!
    }

    fun slideToRight(inter: Interpolator?): Animation {
        transAnim=TranslateAnimation(Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,1.0f,Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,0.0f)
        transAnim?.fillAfter=true
        transAnim?.duration= animDuration
        if (inter!=null){
            transAnim?.interpolator=inter
        }
        return transAnim!!
    }
}