package com.powervision.gcs

import com.powervision.gcs.config.ApiUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * retrofit网络管理类
 * Created by Sundy on 2017/9/5.
 */
class RetrofitManager {
    private var okHttpClient: OkHttpClient?=null
    private var retrofit:Retrofit?=null

    /**
     * 初始化资源
     */
    init {
        if (okHttpClient==null){
            okHttpClient=OkHttpClient().newBuilder()
                    .readTimeout(10000,TimeUnit.MILLISECONDS)
                    .writeTimeout(10000,TimeUnit.MILLISECONDS)
                    .connectTimeout(10000,TimeUnit.MILLISECONDS)
                    .build()
        }

        if (retrofit==null){
            retrofit=Retrofit.Builder()
                    .baseUrl(ApiUrl.getBaseUrl(false))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//用于返回Rxjava调用,非必须
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
        }
    }

    fun <T> createService(clz: Class<T>): T {
        return retrofit!!.create(clz)
    }
    companion object {
        @Volatile
        var init:RetrofitManager?=null

        fun getInstance():RetrofitManager{
            if (init==null){
                synchronized(RetrofitManager::class){
                    if (init==null)
                        init= RetrofitManager()
                }
            }
            return init!!
        }
    }


}