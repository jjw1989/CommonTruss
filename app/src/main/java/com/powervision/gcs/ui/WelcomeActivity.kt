package com.powervision.gcs.ui

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import com.alibaba.android.arouter.launcher.ARouter
import com.powervision.gcs.R
import com.powervision.gcs.base.BaseActivity
import com.powervision.gcs.config.PVFileDir
import com.powervision.gcs.utils.TFileUtil
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import com.yanzhenjie.permission.PermissionNo
import com.yanzhenjie.permission.PermissionYes
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import kotlinx.android.synthetic.main.gcs_welcome_layout.*
import java.util.concurrent.TimeUnit



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
        imgAd.visibility = View.GONE
        tvStartTime.visibility = View.GONE
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
        AndPermission.with(this)
                .requestCode(300)
                .permission(Permission.STORAGE, Permission.LOCATION)
                .callback(this).start()
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

                //    ARouter.getInstance().build("/test/permission").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
                // ARouter.getInstance().build("/ui/main").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
                sendSMS()
            //    ARouter.getInstance().build("/test/permission").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
                ARouter.getInstance().build("/ui/main").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
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

    /**
     * 验证码倒计时
     */
    fun sendSMS() {
        var count: Long = 60 // 设置60秒
        Observable.interval(0, 1, TimeUnit.SECONDS).take(count + 1)
                .map({ along -> count - along })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe({
                    //操作UI
                    button.isEnabled = false
                    button.setTextColor(Color.GRAY)
                }).subscribe(object : Observer<Long> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Long) {
                button.text = t!!.toString() + "秒后重发"
            }

            override fun onComplete() {
                button.setEnabled(true)
                button.setTextColor(Color.RED)
                button.text = "发送验证码"
            }

            override fun onError(e: Throwable) {

            }

        })


    }

    @PermissionYes(300)
    private fun getPermissionYes(grantedPermissions: List<String>) {
        createDir()
        loadSplashImage()
        initNetWork()
    }

    /**
     * 载入广告图片
     */
    private fun loadSplashImage() {
        if (TFileUtil.fileExists(PVFileDir.splashImagePath)) {//如果没有图片就直接跳转到主页

        } else {
            Observable.timer(2, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Observer<Long> {
                        override fun onSubscribe(d: Disposable) {

                        }

                        override fun onNext(t: Long) {

                        }

                        override fun onComplete() {
                            ARouter.getInstance().build("/ui/main")
                                    .withTransition(R.anim.push_right_in, R.anim.push_right_out)
                                    .navigation()
                            finish()
                        }

                        override fun onError(e: Throwable) {

                        }

                    })
        }
    }

    @PermissionNo(300)
    private fun getPermissionNo(deniedPermissions: List<String>) {
        if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {

        }
    }

    /**
     * 获取广告图片
     */
    private fun initNetWork() {
//        val activationParams = JsonParams.getScreenAdvertising("0")
//        val maps = HashMap<String, String>()
//        maps.put(Params.KEY_APP,Params.appkey)
//        maps.put(Params.KEY_DEVICE,Params.device)
//        maps.put(Params.KEY_CHARSET,"zh")
//        maps.put(Params.KEY_VERSION,Params.version)
//        maps.put(Params.KEY_PARAMS,activationParams)

    }

    /**
     * 创建文件目录
     */
    private fun createDir() {
        TFileUtil.createOrExistsDir(PVFileDir.splash)
        TFileUtil.createOrExistsDir(PVFileDir.firmwarePath)
        TFileUtil.createOrExistsDir(PVFileDir.vf_photo)
        TFileUtil.createOrExistsDir(PVFileDir.vf_voideo)
        TFileUtil.createOrExistsDir(PVFileDir.vf_videoThumb)
    }

}
