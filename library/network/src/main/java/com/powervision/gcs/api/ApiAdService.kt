package com.powervision.gcs.api

import com.powervision.gcs.bean.AdModel
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

/**
 * 广告页接口
 * Created by Sundy on 2017/9/6.
 */
interface ApiAdService {
    /**
     * 获取广告页
     */
    @FormUrlEncoded
    @POST()
    fun  getAdInfo(@Url() url:String, @FieldMap maps:Map<String,String>):Flowable<AdModel>
}