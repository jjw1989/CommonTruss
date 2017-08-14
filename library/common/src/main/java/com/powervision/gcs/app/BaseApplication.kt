package com.powervision.gcs.app

import android.support.multidex.BuildConfig
import android.support.multidex.MultiDexApplication
import com.orhanobut.logger.DiskLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * application通用基类
 * Created by David on 2017/8/13.
 */
open class BaseApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        instance=this
        if (BuildConfig.DEBUG){
           initLogger()
        }
    }

    /**
     * 设置logger
     */
    private fun initLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
               // .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("PowerVision")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()
        Logger.addLogAdapter(DiskLogAdapter(formatStrategy))
        //写入到sd卡 logger目录 注意权限
//        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
//        val formatStrategyDisk = CsvFormatStrategy.newBuilder()
//                .tag("PowerVision")
//                .build()
//
//        Logger.addLogAdapter(DiskLogAdapter(formatStrategyDisk))
    }

    companion object {
        var instance: BaseApplication? = null
            private set
    }
}