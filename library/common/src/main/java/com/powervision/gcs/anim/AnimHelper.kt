package com.powervision.gcs.anim

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation

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
    class animListener:Animation.AnimationListener{
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
    class animatorListener:Animator.AnimatorListener{
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