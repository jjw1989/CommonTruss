package com.powervision.gcs.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.powervision.gcs.R
import com.powervision.gcs.ui.fgt.main.FlyFragment
import com.powervision.gcs.ui.fgt.main.MediaFragment
import com.powervision.gcs.ui.fgt.main.ServiceFragment
import com.powervision.gcs.ui.fgt.main.UserCenterFragment
import com.powervision.gcs.view.MainNavigateTabBar
import kotlinx.android.synthetic.main.gcs_main_menu_layout.*


@Route(path = "/test/main")
class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gcs_main_menu_layout)
        initNavigateTabBar(savedInstanceState)
    }

    /**
     * 初始化底部导航控制器
     */
    private fun initNavigateTabBar(savedInstanceState: Bundle?) {
        navigateTabBar.onRestoreInstanceState(savedInstanceState)
        navigateTabBar.addTab(FlyFragment::class.java, MainNavigateTabBar.TabParam(R.mipmap.main_menu_fly, R.mipmap.main_menu_fly_selected, R.string.tab_fly))
        navigateTabBar.addTab(MediaFragment::class.java, MainNavigateTabBar.TabParam(R.mipmap.main_menu_album, R.mipmap.main_menu_album_selected,  R.string.tab_media))
        navigateTabBar.addTab(ServiceFragment::class.java, MainNavigateTabBar.TabParam(R.mipmap.main_menu_find, R.mipmap.main_menu_find_selected, R.string.tab_service))
        navigateTabBar.addTab(UserCenterFragment::class.java, MainNavigateTabBar.TabParam(R.mipmap.main_menu_user, R.mipmap.main_menu_user_selected, R.string.tab_usercenter))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        navigateTabBar.onSaveInstanceState(outState)
    }

}
