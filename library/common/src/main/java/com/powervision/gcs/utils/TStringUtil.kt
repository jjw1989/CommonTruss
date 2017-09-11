package com.powervision.gcs.utils

/**
 * Created by Sundy on 2017/9/11.
 */
object TStringUtil {

    /**
     * 判断字符串是否为空 为空即true
     *
     * @param str 字符串
     * @return
     */
    fun isNullString(str: String?): Boolean {
        return str == null || str.length == 0 || "" == str || "null" == str
    }
}