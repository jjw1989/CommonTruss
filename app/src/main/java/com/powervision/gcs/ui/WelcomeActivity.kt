package com.powervision.gcs.ui

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.view.View
import android.view.animation.AccelerateInterpolator
import com.alibaba.android.arouter.launcher.ARouter
import com.powervision.gcs.R
import com.powervision.gcs.base.BaseActivity
import kotlinx.android.synthetic.main.gcs_welcome_layout.*

/**
 * 欢迎页面
 * Create by Sundy on 2017/8/8
 */
class WelcomeActivity : BaseActivity() {
    /**
     * 接收数据
     */
    override fun initData(bundle: Bundle?) {

    }

    /**
     * 绑定视图
     */
    override fun bindLayout(): Int {
        return R.layout.gcs_welcome_layout
    }

    /**
     * 实例化控件
     */
    override fun initView(savedInstanceState: Bundle?, view: View?) {

    }

    /**
     * 业务处理
     */
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun doBusiness() {
        setScreenArrts()
        initAnim()


    }

    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    private fun initAnim() {
        var alpha:PropertyValuesHolder= PropertyValuesHolder.ofFloat("alpha",0.3f,1.0f)
        var scaleX:PropertyValuesHolder= PropertyValuesHolder.ofFloat("scaleX",0.3f,1.0f)
        var scaleY:PropertyValuesHolder= PropertyValuesHolder.ofFloat("scaleY",0.3f,1.0f)
        var obj1:ObjectAnimator= ObjectAnimator.ofPropertyValuesHolder(imgLogo,alpha,scaleX,scaleY)
        var animatorSet:AnimatorSet= AnimatorSet()
        animatorSet.interpolator=AccelerateInterpolator()
        animatorSet.duration=3000
        animatorSet.play(obj1)
        animatorSet.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                //ARouter.getInstance().build("/set/plane").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
                // ARouter.getInstance().build("/ui/main").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
                ARouter.getInstance()
                        .build("/aty/fly/flight")
                        .withTransition(R.anim.push_right_in,R.anim.push_right_out)
                        .navigation()
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }

        })
    }

    override fun onWidgetClick(view: View) {

    }


}
