package com.powervision.gcs.view.popupwindow

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.bumptech.glide.load.engine.Resource
import com.powervision.gcs.common.R

/**
 * Popupwindow辅助类
 * Created by David on 2017/9/3.
 */
class PopupWindowHelper(view: View) {

    private var popupView: View? = null
    private var mPopupWindow: PopupWindow? = null
    private val TYPE_WRAP_CONTENT = 0
    private val TYPE_MATCH_PARENT = 1

    init {
        this.popupView = view
    }

    /**
     * 在anchor的下面弹出显示
     */
    fun showAsDropDown(anchor: View) {
        mPopupWindow!!.showAsDropDown(anchor)
    }

    /**
     * 在anchor的下面弹出显示并且可以设置显示的位置
     */
    fun showAsDropDown(anchor: View, xoff: Int, yoff: Int) {
        initPopupWindow(TYPE_WRAP_CONTENT)
        mPopupWindow!!.showAsDropDown(anchor, xoff, yoff)
    }

    fun showAtLocation(parent:View,gravity:Int,x:Int,y:Int){
        initPopupWindow(TYPE_WRAP_CONTENT)
        mPopupWindow!!.showAtLocation(parent,gravity,x,y)
    }

    /**
     * 销毁视图
     */
    fun dismiss(){
        if (mPopupWindow!!.isShowing)
            mPopupWindow!!.dismiss()
    }

    /**
     * 在anchor的上面弹出
     */
    fun showAsPopUp(anchor:View){
        showAsPopUp(anchor,0,0)
    }
    /**
     * 在anchor的上面弹出
     */
    fun showAsPopUp(anchor: View,xoff: Int,yoff: Int){
        showAsPopUp(anchor,xoff,yoff)
        initPopupWindow(TYPE_WRAP_CONTENT)
        mPopupWindow!!.animationStyle= R.style.AnimationUpPopup
        popupView!!.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        var height:Int=popupView!!.measuredHeight
        val location = IntArray(2)
        anchor.getLocationInWindow(location)
        mPopupWindow!!.showAtLocation(anchor, Gravity.LEFT or Gravity.TOP, location[0] + xoff, location[1] - height + yoff)
    }

    /**
     * 从底部弹出
     */
    fun showFromBottom(anchor: View){
        initPopupWindow(TYPE_MATCH_PARENT)
        mPopupWindow!!.animationStyle=R.style.AnimationFromButtom
        mPopupWindow!!.showAtLocation(anchor, Gravity.LEFT or Gravity.BOTTOM, 0, 0)
    }

    /**
     * 从顶部弹出
     */
    fun showFromTop(anchor: View){
        initPopupWindow(TYPE_MATCH_PARENT)
        mPopupWindow!!.animationStyle=R.style.AnimationFromTop
        mPopupWindow!!.showAtLocation(anchor,Gravity.LEFT or Gravity.TOP,0,getStatusBarHeight())
    }
    private fun getStatusBarHeight(): Int {
        return Math.round(25 * Resources.getSystem().displayMetrics.density)
    }
    /**
     * 根据布局类型初始化PopupWindow
     */
    fun initPopupWindow(type: Int) {
        if (type == TYPE_WRAP_CONTENT) {
            mPopupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        } else if (type == TYPE_MATCH_PARENT) {
            mPopupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        }
        mPopupWindow!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(true)
    }

    /**
     * 触摸弹窗外是否消失
     */
    fun setCancelable(isCancelable: Boolean) {
        if (isCancelable) {
            mPopupWindow!!.isOutsideTouchable = isCancelable
            mPopupWindow!!.isFocusable = isCancelable
        } else {
            mPopupWindow!!.isOutsideTouchable = isCancelable
            mPopupWindow!!.isFocusable = isCancelable
        }
    }
}