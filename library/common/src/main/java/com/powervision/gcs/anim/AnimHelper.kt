package com.powervision.gcs.anim

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.Interpolator

@SuppressLint("StaticFieldLeak")
/**
 * 动画辅助类
 * Created by Sundy on 2017/7/27.
 */
object AnimHelper {
    private var mActivity: Activity? = null
    private var mView: View? = null
    private var anim: Animation? = null
    private var objAnim: ObjectAnimator? = null

    var animDuration:Long=600
    /**
     * activity从底部进入
     */
    fun getSlideFromBottom(context: Activity,isCloseActivity:Boolean,interpolator: Interpolator?){
        this.mActivity=context
        anim=BaseAnimView.slideFromBottom(interpolator!!)
        if (isCloseActivity) {
            anim!!.setAnimationListener(animListener)
        }
        getRootView(mActivity!!).animation= anim
        getRootView(mActivity!!).startAnimation(anim)
    }

    /**
     * View从底部进入
     */
    fun getSlideFromBottom(mView:View,interpolator: Interpolator?){

    }
    /**************************************/
    /**
     * 获取根视图
     */
    fun getRootView(context: Activity): View {

        return (context.findViewById<View>(android.R.id.content) as ViewGroup)
                .getChildAt(0)
    }

    /**
     * 补间动画监听
     */
   var  animListener: AnimationListener= object :AnimationListener{
        override fun onAnimationRepeat(p0: Animation?) {
        }

        override fun onAnimationEnd(p0: Animation?) {
            mActivity!!.finish()
        }

        override fun onAnimationStart(p0: Animation?) {
        }

    }

    /**
     * 属性动画监听
     */
    var animatorListener: AnimatorListener= object :AnimatorListener{
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
            mActivity!!.finish()
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {

        }


    }
}