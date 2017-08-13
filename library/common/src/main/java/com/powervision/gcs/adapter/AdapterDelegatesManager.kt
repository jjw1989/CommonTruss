package com.powervision.gcs.adapter

import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*

/**
 * Created by David on 2017/8/6.
 */
class AdapterDelegatesManager<T> {
    /**
     *
     */
    val FALLBACK_DELEGATE_VIEW_TYPE = Integer.MAX_VALUE - 1
    /**
     *
     */
    private val PAYLOADS_EMPTY_LIST = Collections.emptyList<Any>()
    /**
     *
     */
    var delegates: SparseArrayCompat<AdapterDelegate<T>> = SparseArrayCompat()
    /**
     *
     */
    var fallbackDelegate: AdapterDelegate<T>? = null

    /**
     *
     */
    fun addDelegate(@NonNull delegate: AdapterDelegate<T>): AdapterDelegatesManager<T> {
        var viewType: Int = delegates.size()
        while (delegates.get(viewType) != null) {
            viewType++
            if (viewType == FALLBACK_DELEGATE_VIEW_TYPE) {
                throw  IllegalArgumentException("Oops, we are very close to Integer.MAX_VALUE. It seems that there are no more free and unused view type integers left to add another AdapterDelegate.")
            }
        }
        return addDelegate(viewType, false, delegate)
    }

    /**
     *
     */
    fun addDelegate(viewType: Int, @NonNull delegate: AdapterDelegate<T>): AdapterDelegatesManager<T> {

        return addDelegate(viewType, false, delegate)
    }

    /**
     *
     */
    fun addDelegate(viewType: Int, allowReplacingDelegate: Boolean, @NonNull delegate: AdapterDelegate<T>): AdapterDelegatesManager<T> {
        if (delegate == null) {
            throw  NullPointerException("AdapterDelegate is null!")
        }
        if (viewType == FALLBACK_DELEGATE_VIEW_TYPE) {
            throw  IllegalArgumentException("The view type = "
                    + FALLBACK_DELEGATE_VIEW_TYPE
                    + " is reserved for fallback adapter delegate (see setFallbackDelegate() ). Please use another view type.");
        }
        if (!allowReplacingDelegate && delegates.get(viewType) != null) {
            throw  IllegalArgumentException(
                    "An AdapterDelegate is already registered for the viewType = "
                            + viewType
                            + ". Already registered AdapterDelegate is "
                            + delegates.get(viewType));
        }

        delegates.put(viewType, delegate);
        return this
    }

    /**
     *
     */
    fun removeDelegate(@NonNull delegate: AdapterDelegate<T>): AdapterDelegatesManager<T> {
        if (delegate == null) {
            throw NullPointerException("AdapterDelegate is null")
        }

        val indexToRemove = delegates.indexOfValue(delegate)

        if (indexToRemove >= 0) {
            delegates.removeAt(indexToRemove)
        }

        return this
    }

    /**
     *
     */
    fun removeDelegate(viewType: Int): AdapterDelegatesManager<T> {
        delegates.remove(viewType)
        return this
    }

    /**
     *
     */
    fun getItemViewType(@NonNull items: T, position: Int): Int {

        if (items == null) {
            throw NullPointerException("Items datasource is null!")
        }

        val delegatesCount = delegates.size()
        for (i in 0..delegatesCount - 1) {
            val delegate = delegates.valueAt(i)
            if (delegate.isForViewType(items, position)) {
                return delegates.keyAt(i)
            }
        }

        if (fallbackDelegate != null) {
            return FALLBACK_DELEGATE_VIEW_TYPE
        }

        throw NullPointerException(
                "No AdapterDelegate added that matches position=$position in data source")
    }

    /**
     *
     */
    @NonNull fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val delegate = getDelegateForViewType(viewType) ?: throw NullPointerException("No AdapterDelegate added for ViewType " + viewType)

        val vh = delegate.onCreateViewHolder(parent) ?: throw NullPointerException("ViewHolder returned from AdapterDelegate "
                + delegate
                + " for ViewType ="
                + viewType
                + " is null!")
        return vh
    }

    /**
     *
     */
    fun onBindViewHolder(@NonNull items: T, position: Int, @NonNull viewHolder: RecyclerView.ViewHolder, payloads: MutableList<Any>?) {
        val delegate = getDelegateForViewType(viewHolder.itemViewType) ?: throw NullPointerException("No delegate found for item at position = "
                + position
                + " for viewType = "
                + viewHolder.itemViewType)
        delegate.onBindViewHolder(items, position, viewHolder,
                payloads ?: PAYLOADS_EMPTY_LIST)
    }

    /**
     *
     */
    fun onBindViewHolder(@NonNull items: T, position: Int, @NonNull viewHolder: RecyclerView.ViewHolder) {
        onBindViewHolder(items, position, viewHolder, PAYLOADS_EMPTY_LIST);
    }

    /**
     *
     */
    fun onViewRecycled(@NonNull viewHolder: RecyclerView.ViewHolder) {
        val delegate = getDelegateForViewType(viewHolder.itemViewType) ?: throw NullPointerException("No delegate found for "
                + viewHolder
                + " for item at position = "
                + viewHolder.adapterPosition
                + " for viewType = "
                + viewHolder.itemViewType)
        delegate.onViewRecycled(viewHolder)
    }

    /**
     *
     */
    fun onFailedToRecycleView(@NonNull viewHolder: RecyclerView.ViewHolder): Boolean {
        val delegate = getDelegateForViewType(viewHolder.itemViewType) ?: throw NullPointerException("No delegate found for "
                + viewHolder
                + " for item at position = "
                + viewHolder.adapterPosition
                + " for viewType = "
                + viewHolder.itemViewType)
        return delegate.onFailedToRecycleView(viewHolder)
    }

    /**
     *
     */
    fun onViewAttachedToWindow(viewHolder: RecyclerView.ViewHolder) {
        val delegate = getDelegateForViewType(viewHolder.itemViewType) ?: throw NullPointerException("No delegate found for "
                + viewHolder
                + " for item at position = "
                + viewHolder.adapterPosition
                + " for viewType = "
                + viewHolder.itemViewType)
        delegate.onViewAttachedToWindow(viewHolder)
    }

    /**
     *
     */
    fun onViewDetachedFromWindow(viewHolder: RecyclerView.ViewHolder) {
        val delegate = getDelegateForViewType(viewHolder.itemViewType) ?: throw NullPointerException("No delegate found for "
                + viewHolder
                + " for item at position = "
                + viewHolder.adapterPosition
                + " for viewType = "
                + viewHolder.itemViewType)
        delegate.onViewDetachedFromWindow(viewHolder)
    }

    /**
     *
     */
    fun setFallbackDelegate(@NonNull fallbackDelegate: AdapterDelegate<T>): AdapterDelegatesManager<T> {
        this.fallbackDelegate = fallbackDelegate
        return this
    }

    /**
     *
     */
    fun getViewType(@NonNull delegate: AdapterDelegate<T>): Int {
        if (delegate == null) {
            throw NullPointerException("Delegate is null")
        }

        val index = delegates.indexOfValue(delegate)
        if (index == -1) {
            return -1
        }
        return delegates.keyAt(index)
    }

    /**
     *
     */
    @Nullable fun getDelegateForViewType(viewType: Int): AdapterDelegate<T> {
        return delegates.get(viewType, fallbackDelegate)
    }

}