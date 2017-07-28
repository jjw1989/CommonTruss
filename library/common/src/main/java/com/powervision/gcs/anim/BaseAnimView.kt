package com.powervision.gcs.anim

import android.animation.ObjectAnimator
import android.view.animation.*

/**
 * 动画封装
 * Created by Sundy on 2017/7/27.
 */
object BaseAnimView {
    var animDuration: Long = 600
    var longAnimDuration: Long = 1000
    private var transAnim: TranslateAnimation? = null
    private var alphaAnim: AlphaAnimation? = null
    private var rotateAnim: RotateAnimation? = null
    private var rotate3dAnim: FlipAnimation? = null
    private var scaleAnim: ScaleAnimation? = null
    private var objAnim: ObjectAnimator? = null

    /**
     * 从底部进入
     */
    fun slideFromBottom(inter: Interpolator): Animation {
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
    fun slideToBottom(inter: Interpolator): Animation {

        return transAnim!!
    }

    /**
     * 从顶部进入
     */
    fun slideFromTop(inter: Interpolator): Animation {

        return transAnim!!
    }

    /**
     * 从顶部退出
     */
    fun slideToTop(inter: Interpolator): Animation {

        return transAnim!!
    }

    /**
     * 从左边进入
     */
    fun slideFromLeft(inter: Interpolator): Animation {

        return transAnim!!
    }

    /**
     * 从左边退出
     */
    fun slideToLeft(inter: Interpolator): Animation {

        return transAnim!!
    }

    /**
     * 逐渐显示
     */
    fun fadingIn(): Animation {

        return alphaAnim!!
    }

    /**
     * 逐渐透明
     */
    fun fadingOut(): Animation {

        return alphaAnim!!
    }

    /**
     *翻转动画
     */
    fun rotate3DFromLeft(inter: Interpolator): Animation {

        return rotate3dAnim!!
    }

    /**
     *翻转动画
     */
    fun rotate3DFromRight(inter: Interpolator): Animation {
        return rotate3dAnim!!
    }

    /**
     * 左侧中心旋转进入
     */
    fun rotateLeftCenterIn(inter: Interpolator): Animation {

        return rotateAnim!!
    }

    /**
     * 左侧中心旋转退出
     */
    fun rotateLeftCenterOut(inter: Interpolator): Animation {

        return rotateAnim!!
    }

    /**
     * 左侧顶部旋转进入
     */
    fun rotateLeftTopIn(inter: Interpolator): Animation {

        return rotateAnim!!
    }

    /**
     * 左侧顶部旋转退出
     */
    fun rotateLeftTopOut(inter: Interpolator): Animation {

        return rotateAnim!!
    }

    /**
     * 从中心旋转进入
     */
    fun rotateCenterIn(inter: Interpolator): Animation {

        return rotateAnim!!
    }

    /**
     * 从中心旋转退出
     */
    fun rotateCenterOut(inter: Interpolator): Animation {

        return rotateAnim!!
    }

    /**
     * 缩放变大
     */
    fun scaleBig(inter: Interpolator): Animation {

        return scaleAnim!!
    }

    /**
     * 缩放变小
     */
    fun scaleSmall(inter: Interpolator): Animation {

        return scaleAnim!!
    }

    /**
     * 左上角缩放变大
     */
    fun scaleBigLeftTop(inter: Interpolator): Animation {

        return scaleAnim!!
    }

    /**
     * 缩小到左上角
     */
    fun scaleSmallLeftTop(inter: Interpolator): Animation {
        return scaleAnim!!
    }

    /**
     * 水平放大
     */
    fun scaleToBigHorizontalIn(inter: Interpolator): Animation {

        return scaleAnim!!
    }

    /**
     * 水平缩小
     */
    fun scaleToBigHorizontalOut(inter: Interpolator): Animation {

        return scaleAnim!!
    }

    /**
     * 垂直放大
     */
    fun scaleToBigVerticalIn(inter: Interpolator): Animation {

        return scaleAnim!!
    }

    /**
     * 垂直缩小
     */
    fun scaleToBigVerticalOut(inter: Interpolator): Animation {

        return scaleAnim!!
    }

    /**
     * 摇动
     */
    fun shakeMode(inter: Interpolator, shakeCount: Int): Animation {

        return transAnim!!
    }

    /*********************************************************************/
    fun slideFromRight(inter: Interpolator): Animation {

        return transAnim!!
    }

    fun slideToRight(inter: Interpolator): Animation {

        return transAnim!!
    }
}