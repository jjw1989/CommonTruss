package com.powervision.gcs.view.indicator

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.powervision.gcs.common.R

import java.util.ArrayList

/**
 * 多功能自定义Banner（需要不断的完善和修改）
 * Created by David on 2017/8/12.
 */
class BannerView : LinearLayout {
    internal var mContext: Context? = null
    private var viewPager: ViewPager? = null
    private var llIndicator: LinearLayout? = null
    //选中图片
    private var RadioSelect = R.drawable.radio_select
    //未选中图片
    private var RadioUnselected = R.drawable.radio_unselected
    //圆点间距
    private var distance = 10
    //视图集合
    internal var listBannerView: MutableList<View> = ArrayList()
    internal var bannerView: View? = null
    private var listView: MutableList<Int>? = null

    //接口
    private var viewControl: ViewControl? = null

    /**
     * 是否显示指示器
     */
    private var isShowIndicator = true

    //设置接口
    fun setViewControl(viewControl: ViewControl) {
        this.viewControl = viewControl
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        LayoutInflater.from(context).inflate(R.layout.pv_view_indicator_layout, this, true)
        viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        llIndicator = findViewById<View>(R.id.llIndicator) as LinearLayout
        //设置空布局
        listView = ArrayList<Int>()
        listView!!.add(R.layout.viewpager_default)
    }

    /**
     * 初始化ViewPager
     */
    private fun initViewPager() {
        listBannerView = ArrayList<View>()
        val layoutInflater = mContext!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val size = listView!!.size
        for (i in 0..size - 1) {
            //循环拿到传入的View
            bannerView = layoutInflater.inflate(listView!![i], null)
            //通过接口回掉的形式返回当前的View,实现接口后开源拿到每个View然后进行操作
            if (viewControl != null) {
                viewControl!!.setView(bannerView!!, i)
            }
            //将获取到的View添加到List中
            listBannerView.add(bannerView!!)
        }
        //设置viewPager的Adapter
        viewPager!!.adapter = ViewPagerAdapter(listBannerView)
        //初始化LinearLayout，加入指示器
        initLinearLayout(viewPager!!, size, llIndicator!!)
    }

    /**
     * 设置指示器，设置ViewPager滑动事件监听
     * @param viewPager    --ViewPager
     * *
     * @param pageSize     --View的页数
     * *
     * @param linearLayout --LinearLayout
     */
    private fun initLinearLayout(viewPager: ViewPager, pageSize: Int, linearLayout: LinearLayout) {
        if (isShowIndicator) {
            linearLayout.visibility = View.VISIBLE
            //定义数组放置指示器的点，pageSize是View个数
            val imageViews = arrayOfNulls<ImageView>(pageSize)
            for (i in 0..pageSize - 1) {
                //创建ImageView
                val image = ImageView(mContext)
                //将ImageView放入数组
                imageViews[i] = image
                //默认选中第一个
                if (i == 0) {
                    //选中的点
                    image.setImageResource(RadioSelect)
                } else {
                    //未选中的点
                    image.setImageResource(RadioUnselected)
                }
                //设置宽高
                val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(distance, 0, distance, 0)
                //将点添加到LinearLayout中
                linearLayout.addView(image, params)
            }

            //ViewPager的滑动事件
            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                }

                override fun onPageSelected(position: Int) {
                    //position当前ViewPager
                    for (i in imageViews.indices) {
                        //设置为选中的点
                        imageViews[position]!!.setImageResource(RadioSelect)
                        //判断当前的点i如果不等于当前页的话就设置为未选中
                        if (position != i) {
                            imageViews[i]!!.setImageResource(RadioUnselected)
                        }
                    }
                }

            })
        } else {
            linearLayout.visibility = View.GONE
        }
    }

    /**
     * 设置圆点距离
     * @param distance --距离
     * *
     * @return
     */
    fun setDistance(distance: Int): BannerView {
        this.distance = distance
        return this
    }

    /**
     * 设置指示器图片
     * @param radioSelect     --选中图片
     * *
     * @param radioUnselected --未选中图片
     * *
     * @return
     */
    fun setIndicator(radioSelect: Int, radioUnselected: Int): BannerView {
        //选中图片
        RadioSelect = radioSelect
        //未选中图片
        RadioUnselected = radioUnselected
        return this
    }

    /**
     * 设置view
     * @param listView --view
     * *
     * @return
     */
    fun setView(listView: MutableList<Int>): BannerView {
        this.listView = listView
        return this
    }

    /**
     * 是否显示指示器
     */
    fun setShowIndicator(showIndicator: Boolean): BannerView {
        isShowIndicator = showIndicator
        return this
    }

    /**
     * 指定显示item的位置
     */
    fun setCurrentItem(position: Int): BannerView {
        viewPager!!.currentItem = position
        return this
    }

    /**
     * 设置初始化
     */
    fun init(): BannerView {
        initViewPager()
        return this
    }
}
