package com.powervision.gcs.permissions

import android.content.Context
import com.yanzhenjie.permission.AndPermission

/**
 * 权限工具类简单封装
 * Created by Yan sundy on 2017/9/6.
 */
class PermissionRequest(private val mContext: Context, private val mCallback: PermissionCallback) {

    fun request() {
       AndPermission.with(mContext)
                .requestCode(110)
                .permission(com.yanzhenjie.permission.Permission.STORAGE, com.yanzhenjie.permission.Permission.LOCATION)
                .callback(this)
                .start()
    }

    @com.yanzhenjie.permission.PermissionYes(110)
    fun yes(permissions: List<String>) {
        this.mCallback.onSuccessful()
    }

    @com.yanzhenjie.permission.PermissionNo(110)
    fun no(permissions: List<String>) {
        println(permissions.toString())
        this.mCallback.onFailure()
    }

    interface PermissionCallback {
        fun onSuccessful()

        fun onFailure()
    }

}