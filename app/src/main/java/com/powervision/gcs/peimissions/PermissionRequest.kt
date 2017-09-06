/*
 * Copyright © Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.powervision.gcs.peimissions

import android.content.Context

import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import com.yanzhenjie.permission.PermissionNo
import com.yanzhenjie.permission.PermissionYes

/**
 * 权限工具类简单封装
 * Created by Yan sundy on 2017/9/6.
 */
class PermissionRequest(private val mContext: Context, private val mCallback: PermissionCallback) {

    fun request() {
        AndPermission.with(mContext)
                .requestCode(110)
                .permission(Permission.STORAGE, Permission.LOCATION)
                .callback(this)
                .start()
    }

    @PermissionYes(110)
    fun yes(permissions: List<String>) {
        this.mCallback.onSuccessful()
    }

    @PermissionNo(110)
    fun no(permissions: List<String>) {
        println(permissions.toString())
        this.mCallback.onFailure()
    }

    interface PermissionCallback {
        fun onSuccessful()

        fun onFailure()
    }

}
