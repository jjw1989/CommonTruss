package com.powervision.gcs.view

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.powervision.gcs.adapter.AdapterDelegatesManager

abstract class AbsDelegationAdapter<T> @JvmOverloads constructor(protected var delegatesManager: AdapterDelegatesManager<T> = AdapterDelegatesManager<T>()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: T? = null

    init {

        if (delegatesManager == null) {
            throw NullPointerException("AdapterDelegatesManager is null")
        }
    }

    /**
     *
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    /**
     *
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(items!!, position, holder, null)
    }

    /**
     *
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>?) {
        delegatesManager.onBindViewHolder(items!!, position, holder, payloads!!)
    }

    /**
     *
     */
    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(items!!, position)
    }

    /**
     *
     */
    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        delegatesManager.onViewRecycled(holder!!)
    }

    /**
     *
     */
    override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean {
        return delegatesManager.onFailedToRecycleView(holder!!)
    }

    /**
     *
     */
    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        delegatesManager.onViewAttachedToWindow(holder!!)
    }

    /**
     *
     */
    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        delegatesManager.onViewDetachedFromWindow(holder!!)
    }
}
