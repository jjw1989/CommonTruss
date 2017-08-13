package com.powervision.gcs.anim

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.Interpolator
import android.util.DisplayMetrics
import com.powervision.gcs.common.R


@SuppressLint("StaticFieldLeak")
/**
 * 动画辅助类
 * Created by Sundy on 2017/7/27.
 */
object AnimHelper {
    private var mAppCompatActivity: AppCompatActivity? = null
    private var mView: View? = null
    private var anim: Animation? = null
    private var objAnim: ObjectAnimator? = null

    var animDuration: Long = 1000
    /**
     * AppCompatActivity从底部进入
     */
    fun getSlideFromBottom(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.slideFromBottom(interpolator)
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        getRootView(mAppCompatActivity!!).animation = anim
        getRootView(mAppCompatActivity!!).startAnimation(anim)
    }

    /**
     * View从底部进入
     */
    fun getSlideFromBottom(mView: View, interpolator: Interpolator?) {
        anim = BaseAnimView.slideFromBottom(interpolator)
        mView.animation = anim
        mView.startAnimation(anim)
    }

    /**
     * AppCompatActivity从底部退出
     */
    fun getSlideToBottom(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.slideToBottom(interpolator)
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        getRootView(mAppCompatActivity!!).animation = anim
        getRootView(mAppCompatActivity!!).startAnimation(anim)
    }

    /**
     *View从底部退出
     */
    fun getSlideToBottom(mView: View, interpolator: Interpolator?) {
        anim = BaseAnimView.slideToBottom(interpolator)
        mView.animation = anim
        mView.startAnimation(anim)
    }

    /**
     * AppCompatActivity从顶部进入
     */
    fun getSlideFromTop(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.slideFromTop(interpolator)
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        getRootView(mAppCompatActivity!!).animation = anim
        getRootView(mAppCompatActivity!!).startAnimation(anim)
    }

    /**
     * View从顶部进入
     */
    fun getSlideFromTop(mView: View, interpolator: Interpolator?) {
        anim = BaseAnimView.slideFromTop(interpolator)
        mView.animation = anim
        mView.startAnimation(anim)
    }

    /**
     * AppCompatActivity从顶部退出
     */
    fun getSlideToTop(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.slideToTop(interpolator)
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        getRootView(mAppCompatActivity!!).animation = anim
        getRootView(mAppCompatActivity!!).startAnimation(anim)
    }

    /**
     * View从顶部退出
     */
    fun getSlideToTop(mView: View, interpolator: Interpolator?) {
        anim = BaseAnimView.slideToTop(interpolator)
        mView.animation = anim
        mView.startAnimation(anim)
    }

    /**
     * AppCompatActivity从左边进入
     */
    fun getSlideFromLeft(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.slideFromLeft(interpolator)
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        getRootView(mAppCompatActivity!!).animation = anim
        getRootView(mAppCompatActivity!!).startAnimation(anim)
    }

    /**
     * View从左边进入
     */
    fun getSlideFromLeft(mView: View, interpolator: Interpolator?) {
        anim = BaseAnimView.slideFromLeft(interpolator)
        mView.animation = anim
        mView.startAnimation(anim)
    }

    /**
     * AppCompatActivity从左边退出
     */
    fun getSlideToLeft(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.slideToLeft(interpolator)
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        getRootView(mAppCompatActivity!!).animation = anim
        getRootView(mAppCompatActivity!!).startAnimation(anim)
    }

    /**
     * View从左边退出
     */
    fun getSlideToLeft(mView: View, interpolator: Interpolator?) {
        anim = BaseAnimView.slideToLeft(interpolator)
        mView.animation = anim
        mView.startAnimation(anim)
    }

    /**
     * AppCompatActivity从右边进入
     */
    fun getSlideFromRight(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.slideFromRight(interpolator)
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }

    /**
     * View从右边进入
     */
    fun getSlideFromRight(mView: View, interpolator: Interpolator?) {
        this.mView = mView
        anim = BaseAnimView.slideFromRight(interpolator)
        onStartAnim(false)
    }

    /**
     * AppCompatActivity从右边退出
     */
    fun getSlideToRight(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.slideToRight(interpolator)
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }

    /**
     * View从右边退出
     */
    fun getSlideToRight(mView: View, interpolator: Interpolator?) {
        this.mView = mView
        anim = BaseAnimView.slideToRight(interpolator)
        onStartAnim(false)
    }

    /**
     * AppCompatActivity淡入
     */
    fun getFadingIn(context: AppCompatActivity) {
        this.mAppCompatActivity = context
        anim = BaseAnimView.fadingIn()
        onStartAnim(true)
    }

    /**
     * View淡入
     */
    fun getFadingIn(mView: View) {
        this.mView = mView
        anim = BaseAnimView.fadingIn()
        onStartAnim(false)
    }

    /**
     * AppCompatActivity淡出
     */
    fun getFadingOut(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }

    /**
     * view淡出
     */
    fun getFadingOut(mView: View) {
        this.mView = mView
        anim = BaseAnimView.fadingOut()
        onStartAnim(false)
    }

    /**
     *AppCompatActivity逆时针翻转
     */
    fun getRotate3DFromLeft(context: AppCompatActivity, isCloseAppCompatActivity: Boolean, interpolator: Interpolator?) {
        this.mAppCompatActivity = context
        var wm: WindowManager = mAppCompatActivity!!.windowManager
        val metric = DisplayMetrics()
        wm.defaultDisplay.getMetrics(metric)
        var width = metric.widthPixels
        var height = metric.heightPixels
        var rotate3dAnim: FlipAnimation = FlipAnimation((width / 2).toFloat(), (height / 2).toFloat(), false)
        if (interpolator != null) {
            rotate3dAnim.interpolator = interpolator
        }
        rotate3dAnim.duration = animDuration
        anim = rotate3dAnim
        if (isCloseAppCompatActivity) {
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }

    /**
     * view逆时针翻转
     */
    fun getRotate3DFromLeft(mView: View, interpolator: Interpolator?) {
        this.mView = mView
        var rotate3DAnim: FlipAnimation = FlipAnimation((this.mView!!.width / 2).toFloat(), (this.mView!!.height / 2).toFloat(), false)
        if (interpolator != null) {
            rotate3DAnim.interpolator = interpolator
        }
        rotate3DAnim.duration = animDuration
        anim = rotate3DAnim
        onStartAnim(false)
    }

    /**
     * AppCompatActivity左侧中心旋转进入
     */
    fun getRotateLeftCenterIn(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.rotateLeftCenterIn(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }
    /**
     * View左侧中心旋转进入
     */
    fun getRotateLeftCenterIn(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.rotateLeftCenterIn(interpolator)
        onStartAnim(false)
    }
    /**
     * AppCompatActivity左侧中心旋转退出
     */
    fun getRotateLeftCenterOut(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.rotateLeftCenterOut(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }
    /**
     * View左侧中心旋转退出
     */
    fun getRotateLeftCenterOut(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.rotateLeftCenterOut(interpolator)
        onStartAnim(false)
    }

    /**
     * AppCompatActivity从左侧顶部旋转进入
     */
    fun getRotateLeftTopIn(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
       this.mAppCompatActivity=context
        anim=BaseAnimView.rotateLeftTopIn(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }
    /**
     * view从左侧顶部旋转进入
     */
    fun getRotateLeftTopIn(mView: View,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.rotateLeftTopIn(interpolator)
        onStartAnim(false)
    }

    /**
     * AppCompatActivity从左侧顶部旋转退出
     */
    fun getRotateLeftTopOut(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.rotateLeftTopOut(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }

    /**
     * view从左侧顶部旋转退出
     */
    fun getRotateLeftTopOut(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.rotateLeftTopOut(interpolator)
        onStartAnim(false)
    }
    /**
     * AppCompatActivity在x轴逆时针旋转
     */
    fun flipUpDown(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        objAnim= ObjectAnimator.ofFloat(getRootView(context),"rotationX",-180f,0f)
        if (interpolator!=null){
            objAnim!!.interpolator=interpolator
        }
        objAnim!!.duration= animDuration
        if (isCloseAppCompatActivity){
            objAnim!!.addListener(animatorListener)
        }
       var animatorSet: AnimatorSet= AnimatorSet()
        animatorSet.play(objAnim!!)
        animatorSet.start()
    }

    /**
     * View早x轴逆时针旋转
     */
    fun flipUpDown(mView: View,interpolator: Interpolator?){
        objAnim= ObjectAnimator.ofFloat(mView,"rotationX",0f,360f)
        if (interpolator!=null){
            objAnim!!.interpolator=interpolator
        }
        objAnim!!.duration= animDuration
        var animatorSet:AnimatorSet= AnimatorSet()
        animatorSet.play(objAnim!!)
        animatorSet.start()
    }

    /**
     * AppCompatActivity从中心旋转进入
     */

    fun rotateCenterIn(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.rotateCenterIn(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }
    /**
     * view从中心旋转进入
     */
    fun rotateCenterIn(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.rotateCenterIn(interpolator)
        onStartAnim(false)
    }
    /**
     * AppCompatActivity从中心旋转退出
     */
    fun rotateCenterOut(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.rotateCenterOut(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }
    /**
     * view从中心旋转退出
     */
    fun rotateCenterOut(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.rotateCenterOut(interpolator)
        onStartAnim(false)
    }

    /**
     * AppCompatActivity 由小变大
     */
    fun getScaleBig(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.scaleBig(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }
    /**
     * view 由小变大
     */
    fun getScaleBig(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.scaleBig(interpolator)
        onStartAnim(false)
    }

    /**
     * AppCompatActivity由小变大
     */
    fun scaleSmall(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.scaleSmall(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }

    /**
     * view由小变大
     */
    fun scaleSmall(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.scaleSmall(interpolator)
        onStartAnim(false)
    }

    /**
     * AppCompatActivity从左上逐步变大
     */
    fun scaleBigLeftTop(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.scaleBigLeftTop(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }
    /**
     * view从左上逐步变大
     */
    fun scaleBigLeftTop(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.scaleBigLeftTop(interpolator)
        onStartAnim(false)
    }
    /**
     * AppCompatActivity从左上逐步变小
     */
    fun scaleSmallLeftTop(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.scaleSmallLeftTop(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }
    /**
     * view从左上逐步变小
     */
    fun scaleSmallLeftTop(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.scaleSmallLeftTop(interpolator)
        onStartAnim(false)
    }

    fun scaleToBigHorizontalIn(context: AppCompatActivity,isCloseAppCompatActivity: Boolean,interpolator: Interpolator?){
        this.mAppCompatActivity=context
        anim=BaseAnimView.scaleToBigHorizontalIn(interpolator)
        if (isCloseAppCompatActivity){
            anim!!.setAnimationListener(animListener)
        }
        onStartAnim(true)
    }

    fun scaleToBigHorizontalIn(mView: View,interpolator: Interpolator?){
        this.mView=mView
        anim=BaseAnimView.scaleToBigHorizontalIn(interpolator)
        onStartAnim(false)
    }
    /**
     * 通用开启动画
     */
    fun onStartAnim(isAppCompatActivity: Boolean) {
        if (isAppCompatActivity) {
            getRootView(mAppCompatActivity!!).animation = anim
            getRootView(mAppCompatActivity!!).startAnimation(anim)
        } else {
            mView!!.animation = anim
            mView!!.startAnimation(anim)
        }
    }


    /**************************************/
    /**
     * 获取根视图
     */
    fun getRootView(context: AppCompatActivity): View {

//        return (context.findViewById<View>(android.R.id.content) as ViewGroup)
//                .getChildAt(0)
        return context.window.decorView.findViewById(android.R.id.content)
    }

    /**
     * 补间动画监听
     */
    var animListener: AnimationListener = object : AnimationListener {
        override fun onAnimationRepeat(p0: Animation?) {
        }

        override fun onAnimationEnd(p0: Animation?) {
            mAppCompatActivity!!.finish()
        }

        override fun onAnimationStart(p0: Animation?) {
        }

    }

    /**
     * 属性动画监听
     */
    var animatorListener: AnimatorListener = object : AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
            mAppCompatActivity!!.finish()
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {

        }


    }
}