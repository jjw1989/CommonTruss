package com.powervision.gcs.api

import com.powervision.gcs.bean.AdModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 广告页接口
 * Created by Sundy on 2017/9/6.
 */
interface ApiAdService {
    /**
     * 获取广告页
     */
    @GET("")
    fun  getAdInfo(@Query("ip") ip:String):Observable<AdModel>
}