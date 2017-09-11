package com.powervision.gcs.ui

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Build
import android.os.Bundle
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
        AndPermission.with(this)
                .requestCode(300)
                .permission(
                        Permission.STORAGE,Permission.LOCATION)
                .callback(this).start()
    }

    private fun initNetWork() {
//        val activationParams = JsonParams.getScreenAdvertising("0")
//        val maps = HashMap<String, String>()
//        maps.put(Params.KEY_APP,Params.appkey)
//        maps.put(Params.KEY_DEVICE,Params.device)
//        maps.put(Params.KEY_CHARSET,"zh")
//        maps.put(Params.KEY_VERSION,Params.version)
//        maps.put(Params.KEY_PARAMS,activationParams)

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

    @PermissionYes(300)
    private fun getPermissionYes(grantedPermissions: List<String>) {
        createDir()

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

    @PermissionNo(300)
    private fun getPermissionNo(deniedPermissions: List<String>) {
        if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {

        }
    }


}
