package com.powervision.gcs.adapter

import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by David on 2017/8/6.
 */
abstract class AdapterDelegate<T> {
    /**
     *
     */
    abstract fun isForViewType(@NonNull items: T, position: Int): Boolean

    /**
     *
     */
    @NonNull abstract fun onCreateViewHolder(@NonNull parent: ViewGroup): RecyclerView.ViewHolder

    /**
     *
     */
    abstract fun onBindViewHolder(@NonNull items: T, position: Int, @NonNull holder: RecyclerView.ViewHolder, @NonNull payloads: List<Any>)

    /**
     *
     */
    fun onViewRecycled(@NonNull viewHolder: RecyclerView.ViewHolder) {

    }

    /**
     *
     */
    fun onFailedToRecycleView(@NonNull holder: RecyclerView.ViewHolder): Boolean {
        return false
    }

    /**
     *
     */
    fun onViewAttachedToWindow(@NonNull holder: RecyclerView.ViewHolder) {

    }

    /**
     *
     */
    fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {

    }
}