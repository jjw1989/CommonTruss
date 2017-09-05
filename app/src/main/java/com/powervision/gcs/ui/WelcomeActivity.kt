package com.powervision.gcs.ui

import android.Manifest
import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.powervision.gcs.R
import com.powervision.gcs.base.BaseActivity
import kotlinx.android.synthetic.main.gcs_welcome_layout.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.AppSettingsDialog




/**
 * 欢迎页面
 * Create by Sundy on 2017/8/8
 */
class WelcomeActivity : BaseActivity(), EasyPermissions.PermissionCallbacks {
    private val ADD_PERMISSIONS = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
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
        onRequestPermissions()
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

    fun requestBasicPermission(): Boolean {
        return EasyPermissions.hasPermissions(this, *ADD_PERMISSIONS)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>?) {//
        Log.i("qaz", "111requestCode=$requestCode,perms=$perms")

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>?) { //同意了某些权限可能不是全部
        Log.i("qaz", "222requestCode=$requestCode,perms=$perms")
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms!!)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    @AfterPermissionGranted(1000)
    fun onRequestPermissions() {
        if (requestBasicPermission()) {
            Toast.makeText(this, "已经或得权限", Toast.LENGTH_LONG).show()
        } else {
            EasyPermissions.requestPermissions(this, "请给予应用必要权限，让程序可正常工作", 1000, *ADD_PERMISSIONS)
            Toast.makeText(this, "没有或得权限", Toast.LENGTH_LONG).show()
        }
    }
}
