package com.powervision.gcs

import com.powervision.gcs.api.ApiAdService
import com.powervision.gcs.config.ApiUrl
import com.powervision.gcs.utils.JsonUtil
import com.powervision.gcs.utils.LogUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.reactivestreams.Subscriber
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
        LogUtil.init(true)
        if (okHttpClient==null){
            val logInterceptor = HttpLoggingInterceptor(HttpLogger())
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient=OkHttpClient().newBuilder()
                    .readTimeout(10000,TimeUnit.MILLISECONDS)
                    .writeTimeout(10000,TimeUnit.MILLISECONDS)
                    .connectTimeout(10000,TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(logInterceptor)
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

    fun getApiAdservice(): ApiAdService {

        return createService(ApiAdService::class.java)
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

    private inner class HttpLogger : HttpLoggingInterceptor.Logger {
        private val mMessage = StringBuilder()

        override fun log(message: String) {
            var message = message
            // 请求或者响应开始
            if (message.startsWith("--> POST")) {
                mMessage.setLength(0)
            }
            // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
            if (message.startsWith("{") && message.endsWith("}") || message.startsWith("[") && message.endsWith("]")) {
                message = JsonUtil.formatJson(message)
            }
            mMessage.append(message + "\n")
            // 请求或者响应结束，打印整条日志
            if (message.startsWith("<-- END HTTP")) {
                LogUtil.d(mMessage.toString())
            }
        }
    }

}