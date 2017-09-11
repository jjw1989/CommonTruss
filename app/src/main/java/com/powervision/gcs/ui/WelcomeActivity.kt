package com.powervision.gcs.ui

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.icu.util.TimeUnit
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.powervision.gcs.R
import com.powervision.gcs.RetrofitManager
import com.powervision.gcs.api.ApiAdService
import com.powervision.gcs.base.BaseActivity
import com.powervision.gcs.peimissions.PermissionRequest
import com.powervision.gcs.utils.LogUtil
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.util.HalfSerializer.onNext
import io.reactivex.schedulers.Schedulers
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
        permissionsRequest()
        testRxJava()
    }

    private fun testRxJava() {




    }

    /**
     * 权限请求
     */
    private fun permissionsRequest() {
      var requestPermissons=PermissionRequest(this,object :PermissionRequest.PermissionCallback{
          override fun onSuccessful() {
             Toast.makeText(this@WelcomeActivity,"111111111111111111111111",Toast.LENGTH_LONG).show()
              LogUtil.i("1111111111111111111111111111111111111")
              initNetWork()
          }

          override fun onFailure() {
              LogUtil.i("22222222222222222222222222222222222222")
          }

      })
        requestPermissons.request()
    }

    private fun initNetWork() {

//       RetrofitManager.getInstance().createService(ApiAdService::class.java).getAdInfo("").subscribeOn(Schedulers.io())
//               .unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).su


    }

    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    private fun initAnim() {
        val alpha: PropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", 0.3f, 1.0f)
        val scaleX: PropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1.0f)
        val scaleY: PropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1.0f)
        val animator: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(imgLogo, alpha, scaleX, scaleY)
        animator.interpolator = AccelerateInterpolator()
        animator.duration = 1000
        animator.start()
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                //ARouter.getInstance().build("/set/plane").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
                // ARouter.getInstance().build("/ui/main").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
//                ARouter.getInstance()
//                        .build("/aty/fly/flight")
//                        .withTransition(R.anim.push_right_in,R.anim.push_right_out)
//                        .navigation()
//                finish()
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
