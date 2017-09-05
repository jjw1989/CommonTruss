package com.powervision.gcs.config

/**
 * 网络请求配置文件
 * Created by David on 2017/8/5.
 */
object ApiUrl {
  //测试地址
  val BASE_URL_TEST= "http://123.57.163.139:8099"
  val BASE_URL="http://api.powervision.me"

    /**
     * 获取域名
     */
    fun getBaseUrl(isOfficial:Boolean):String{
        if (isOfficial){
            return BASE_URL
        }else{
            return BASE_URL_TEST
        }
    }
}