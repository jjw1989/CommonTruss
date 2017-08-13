package com.powervision.gcs.adapter

import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by David on 2017/8/6.
 */
abstract class AbsListItemAdapterDelegate<I : T, T, VH : RecyclerView.ViewHolder> : AdapterDelegate<List<T>>() {
    /**
     *
     */
    final override fun isForViewType(items: List<T>, position: Int): Boolean {
        return isForViewType(items.get(position), items, position)
    }

    /**
     *
     */
    final override fun onBindViewHolder(@NonNull items: List<T>, posotion: Int, @NonNull holder: RecyclerView.ViewHolder, payloads: List<Any>) {

    }

    /**
     *
     */
    abstract fun isForViewType(@NonNull item: T, @NonNull items: List<T>, position: Int): Boolean

    /**
     *
     */
    @NonNull abstract override fun onCreateViewHolder(parent: ViewGroup): VH

    /**
     *
     */
    abstract fun onBindViewHolder(@NonNull item: T, @NonNull viewHolder: VH, @NonNull payloads: List<Any>)

}