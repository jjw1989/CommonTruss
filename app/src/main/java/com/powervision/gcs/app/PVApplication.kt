package com.powervision.gcs.app

import android.support.multidex.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter
import com.powervision.gcs.sdk.PVConnConfig
import com.powervision.gcs.sdk.PVConnManager

/**
 * 真对当前项目设置的全局属性和方法
 * Created by Sundy on 2017/8/2.
 */
class PVApplication: BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        initARouter()
        initSDK()
    }

    /**
     * 初始化sdk
     */
    private fun initSDK() {
        var manager: PVConnManager = PVConnManager.getInstance()
        var config: PVConnConfig = PVConnConfig.Builder().builder()
        manager.initSDK(config)
    }

    /**
     * 初始化路由管理
     */
    private fun initARouter() {
        if (true) {       // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()          // 打印日志
            ARouter.openDebug()        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.printStackTrace()  // 打印日志的时候打印线程堆栈
        }
        ARouter.init(this)  // 尽可能早，推荐在Application中初始化
    }
}