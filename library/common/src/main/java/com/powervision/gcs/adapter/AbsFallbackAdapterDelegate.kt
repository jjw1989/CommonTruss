package com.powervision.gcs.adapter

/**
 * This class can be used as base class for a fallback delegate {@link
 * AdapterDelegatesManager#setFallbackDelegate(AdapterDelegate)}.
 * Created by David on 2017/8/6.
 */
abstract class AbsFallbackAdapterDelegate<T>: AdapterDelegate<T>() {
    /**
     * Not needed, because never called for fallback adapter delegates.
     *
     * @param items The data source of the Adapter
     * @param position The position in the datasource
     * @return true
     */
    override fun isForViewType(items: T, position: Int): Boolean {
        return true
    }
}