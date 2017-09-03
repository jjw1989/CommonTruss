package com.powervision.gcs.ui.aty.fly

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.powervision.gcs.R
import com.powervision.gcs.base.BaseActivity
import com.powervision.gcs.view.popupwindow.PopupWindowHelper
import com.powervision.gcs.view.seekbar.ProgressItem
import kotlinx.android.synthetic.main.pv_fly_controller_manager_layout.*


/**
 * 飞控主页
 * Create by Sundy on 2017/8/29
 */
@Route(path = "/aty/fly/flight")
class PVFlightControllerActivity : BaseActivity() {

    /**
     * 接受数据
     */
    override fun initData(bundle: Bundle?) {

    }

    /**
     * 绑定视图
     */
    override fun bindLayout(): Int {

        return R.layout.pv_fly_controller_manager_layout
    }

    /**
     * 绑定控件
     */
    override fun initView(savedInstanceState: Bundle?, view: View?) {
       setScreenArrts()
    }
    var helper:PopupWindowHelper?=null
    /**
     * 业务操作
     */
    override fun doBusiness() {
        var popupView=View.inflate(this,R.layout.pv_test,null)
         helper=   PopupWindowHelper(popupView)
       button2.setOnClickListener(this)
    }

    override fun onWidgetClick(view: View) {
       when(view.id){
          // R.id.button2->helper!!.showAsPopUp(view!!)
          // R.id.button2->helper!!.showAsDropDown(view!!)
          // R.id.button2->helper!!.showAtLocation(view!!,Gravity.TOP,0,0)
          // R.id.button2->helper!!.showFromBottom(view!!)
           R.id.button2->helper!!.showFromTop(view!!)
       }
    }

    private val totalSpan = 1500f
    private val redSpan = 500f
    private val greenSpan = 500f
    private val yellowSpan = 500f
    var view: View? = null
    private var mProgressItem: ProgressItem? = null
    private var progressItemList: ArrayList<ProgressItem>? = null

    private fun initDataToSeekbar() {
        progressItemList = ArrayList()
        // red span
        mProgressItem = ProgressItem()
        mProgressItem!!.progressItemPercentage = redSpan / totalSpan * 100

        mProgressItem!!.color = R.color.red
        progressItemList!!.add(mProgressItem!!)

        // green span
        mProgressItem = ProgressItem()
        mProgressItem!!.progressItemPercentage = greenSpan / totalSpan * 100
        mProgressItem!!.color = R.color.green
        progressItemList!!.add(mProgressItem!!)
        // yellow span
        mProgressItem = ProgressItem()
        mProgressItem!!.progressItemPercentage = yellowSpan / totalSpan * 100
        mProgressItem!!.color = R.color.yellow
        progressItemList!!.add(mProgressItem!!)

//        seekBar.initData(progressItemList)
//        seekBar.invalidate()

    }
}
