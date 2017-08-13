package com.powervision.gcs.adapter

import com.powervision.gcs.view.AbsDelegationAdapter

/**
 * Created by David on 2017/8/6.
 */
class ListDelegationAdapter<T :List<out T>> :AbsDelegationAdapter<T>(){

    override fun getItemCount(): Int {
        return if (items==null) 0 else items!!.size
    }
}