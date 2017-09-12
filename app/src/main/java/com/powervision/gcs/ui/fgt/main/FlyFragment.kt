package com.powervision.gcs.ui.fgt.main


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.powervision.gcs.R
import com.powervision.gcs.base.BaseFragment
import com.powervision.gcs.glide.ProgressTarget
import com.powervision.gcs.view.largeimage.factory.FileBitmapDecoderFactory
import kotlinx.android.synthetic.main.pv_main_fly_layout.*
import java.io.File

/**
 * 飞机切换主页
 * Create by Sundy on 2017/8/31
 */
class FlyFragment : BaseFragment() {
    /**
     * 接收上个界面的数据
     */
    override fun initData(bundle: Bundle?) {

    }

    /**
     * 绑定视图
     */
    override fun bindLayout(): Int {
      return R.layout.pv_main_fly_layout
    }

    /**
     * 绑定控件
     */
    override fun initView(savedInstanceState: Bundle?, view: View?) {

    }

    /**
     * 处理业务
     */
    override fun doBusiness() {
        val url = "http://img.tuku.cn/file_big/201502/3d101a2e6cbd43bc8f395750052c8785.jpg"
        Glide.with(this).load(url).downloadOnly(object : ProgressTarget<String, File>(url, null) {
            override fun onLoadStarted(placeholder: Drawable?) {
                super.onLoadStarted(placeholder)
            }

            override fun onProgress(bytesRead: Long, expectedLength: Long) {

            }

            override fun onResourceReady(resource: File?, transition: Transition<in File>?) {
                super.onResourceReady(resource, transition)
                Log.i("imageview","imagePath="+resource!!.absolutePath)
                largeImageView.setImage(FileBitmapDecoderFactory(resource))
            }

            override fun getSize(cb: SizeReadyCallback?) {
                cb!!.onSizeReady(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
               // super.getSize(cb)
            }

//         override  fun onLoadStarted(placeholder: Drawable) {
//                super.onLoadStarted(placeholder)
//               // ringProgressBar.setVisibility(View.VISIBLE)
//                //ringProgressBar.setProgress(0)
//            }
//
//            override  fun onProgress(bytesRead: Long, expectedLength: Long) {
//                var p = 0
//                if (expectedLength >= 0) {
//                    p = (100 * bytesRead / expectedLength).toInt()
//                }
//               // ringProgressBar.setProgress(p)
//            }
//
//            override fun onResourceReady(resource: File, animation: GlideAnimation<in File>) {
//                super.onResourceReady(resource, animation)
//               // ringProgressBar.setVisibility(View.GONE)
//                largeImageView.setImage(FileBitmapDecoderFactory(resource))
//            }
//
//            override   fun getSize(cb: SizeReadyCallback) {
//                cb.onSizeReady(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//            }
        })
        Log.i("filePath","path11="+Glide.getPhotoCacheDir(context))
    }

    override fun onWidgetClick(view: View) {

    }

}
