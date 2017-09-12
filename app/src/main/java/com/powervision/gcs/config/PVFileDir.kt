package com.powervision.gcs.config

import android.os.Environment

/**
 * 文件目录常量
 * Created by Sundy on 2017/9/11.
 */
object PVFileDir {
    /**
     * 广告页目录
     */
    val splash= Environment.getExternalStorageDirectory().getPath() + "/GCS/Splash"
    /**
     * 主目录
     */
    val miandir = Environment.getExternalStorageDirectory().toString() + "/GCS"
    /**
     * vf图片存储路径
     */
    val vf_photo = Environment.getExternalStorageDirectory().toString() + "/GCS/camera/"
    /**
     * vf视屏存储路径
     */
    val vf_voideo = Environment.getExternalStorageDirectory().toString() + "/GCS/video/"
    /**
     * vf视屏缩略图
     */
    val vf_videoThumb = Environment.getExternalStorageDirectory().toString() + "/GCS/video/.thumbnails/"
    /**
     * 固件保存路径
     */
    val firmwarePath = Environment.getExternalStorageDirectory().toString() + "/GCS/firmware/"
    /**
     * 广告图片的绝对路径
     */
    val splashImagePath = Environment.getExternalStorageDirectory().path + "/GCS/Splash/splash.png"
}