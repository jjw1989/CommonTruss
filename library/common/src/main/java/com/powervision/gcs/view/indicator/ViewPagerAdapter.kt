package com.powervision.gcs.view.indicator

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

class ViewPagerAdapter(views: List<View>) : PagerAdapter() {

    private var views: List<View>? = null

    init {
        this.views = views
    }

    override fun getCount(): Int {
        return if (views!!.size > 0) views!!.size else 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(viewGroup: ViewGroup, i: Int): Any {
        viewGroup.addView(views!![i])
        return views!![i]
    }

    override fun destroyItem(viewGroup: ViewGroup, i: Int, `object`: Any) {
        viewGroup.removeView(views!![i])
    }

}
