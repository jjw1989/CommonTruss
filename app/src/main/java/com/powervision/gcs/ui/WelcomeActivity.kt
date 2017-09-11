package com.powervision.gcs.ui

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.icu.util.TimeUnit
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import com.powervision.gcs.R
import com.powervision.gcs.RetrofitManager
import com.powervision.gcs.api.ApiAdService
import com.powervision.gcs.base.BaseActivity
<<<<<<< HEAD
import com.powervision.gcs.peimissions.PermissionRequest
import com.powervision.gcs.utils.LogUtil
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.util.HalfSerializer.onNext
import io.reactivex.schedulers.Schedulers
=======
import com.powervision.gcs.config.PVFileDir
import com.powervision.gcs.utils.TFileUtil
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import com.yanzhenjie.permission.PermissionNo
import com.yanzhenjie.permission.PermissionYes
>>>>>>> f683a358151577515462e24eae4ba1121c84beff
import kotlinx.android.synthetic.main.gcs_welcome_layout.*
import java.util.*


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
<<<<<<< HEAD
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
=======
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

>>>>>>> f683a358151577515462e24eae4ba1121c84beff
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
            //    ARouter.getInstance().build("/test/permission").withTransition(R.anim.push_right_in,R.anim.push_right_out).navigation()
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

    @PermissionYes(300)
    private fun getPermissionYes(grantedPermissions: List<String>) {
        // Successfully.
        Log.i("qazx", "111111111111111111111"+grantedPermissions.toString())
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
        // Failure.
        Log.i("qazx", "222222222222222222222222"+deniedPermissions.toString())
        if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {
//            AndPermission.with(this)
//                    .requestCode(300)
//                    .permission(
//                            Permission.SENSORS,Permission.LOCATION)
//                    .callback(this).start()
        }
    }


}
